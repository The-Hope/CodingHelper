package cn.xunyard.idea.coding.doc.logic.object;

import cn.xunyard.idea.coding.doc.logic.ClassUtils;
import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.ClassDescriber;
import cn.xunyard.idea.coding.log.Logger;
import cn.xunyard.idea.coding.log.LoggerFactory;
import cn.xunyard.idea.coding.util.AssertUtils;
import com.google.common.base.Joiner;
import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a herf="mailto:wuqi@terminus.io">xunyard</a>
 * @date 2019-12-15
 */
public class ObjectScanner {
    private final Logger log = LoggerFactory.getLogger(ProcessContext.IDENTITY);
    private final ProcessContext processContext;
    private final String serviceSuffix;
    private final List<String> objectNameList;
    private final String packagePrefix;

    private final List<JavaClass> scannedObjects;

    public ObjectScanner(ProcessContext processContext) {
        this.processContext = processContext;
        this.objectNameList = processContext.getConfiguration().getObjectSuffixList();
        this.serviceSuffix = wrapService(processContext.getConfiguration().getServiceSuffix());
        this.packagePrefix = wrapPackage(processContext.getConfiguration().getPackagePrefix());

        this.scannedObjects = new LinkedList<>();
    }

    private String wrapPackage(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return null;
        }

        if (!prefix.contains(".")) {
            return prefix;
        }

        return Joiner.on("/").skipNulls().join(prefix.split("\\."));
    }

    private String wrapService(String suffix) {
        if (suffix == null || suffix.length() == 0) {
            return null;
        }

        return suffix;
    }

    public List<JavaClass> scan(String basePath) {
        // 扫描并加载配置中的源文件路径
        if (!AssertUtils.isEmpty(processContext.getConfiguration().getSourceInclude())) {
            log.info("开始读取源文件工程...");
            for (String path : processContext.getConfiguration().getSourceInclude()) {
                scanForClassLoader(path);
            }
        }

        log.info("开始扫描服务类...");
        scanSearchObject(basePath);
        log.info(String.format("扫描完成!共发现%d个服务", scannedObjects.size()));
        return scannedObjects;
    }

    /**
     * 扫描类加载
     *
     * @param path 包路径
     */
    private void scanForClassLoader(String path) {
        File file = new File(path);

        // 如果是文件夹，递归下级文件夹继续扫描
        if (file.isDirectory()) {
            String[] children = file.list();

            if (children == null) {
                return;
            }

            for (String child : children) {
                scanForClassLoader(path + "/" + child);
            }
        } else {
            // 如果是文件，检查文件后缀无误后加入 loader 内中
            if (!file.exists()) {
                log.error("检测到无效文件地址:" + path);
                throw new IllegalArgumentException("invalid.file.path");
            }

            if (!path.endsWith(processContext.getConfiguration().getFileSuffix()) || !ClassUtils.isSrcClass(path)) {
                return;
            }

            processContext.getSourceClassLoader().loadClass(path);
        }
    }

    /**
     * 扫描加载对象类
     *
     * @param path 目标地址
     */
    private void scanSearchObject(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            String[] children = file.list();

            if (children == null) {
                return;
            }

            for (String child : children) {
                // 一些特殊路径的处理
                switch (child) {
                    case ".git":
                        continue;
                }
                scanSearchObject(path + "/" + child);
            }
        } else {
            if (!file.exists()) {
                log.error("检测到无效文件地址:" + path);
                throw new IllegalArgumentException("invalid.file.path");
            }

            if (!path.endsWith(processContext.getConfiguration().getFileSuffix())
                    || !(ClassUtils.isSrcClass(path) || ClassUtils.isTestSrcClass(path))) {
                return;
            }

            List<JavaClass> javaClasses = processContext.getSourceClassLoader().loadClass(path);
            if (AssertUtils.isEmpty(javaClasses)) {
                return;
            }
            ClassDescriber classDescriber = processContext.getClassDescriberMaker().simpleFromClass(path);

            if (!AssertUtils.isEmpty(packagePrefix) && !Objects.requireNonNull(classDescriber.getPackage()).startsWith(packagePrefix)) {
                return;
            }

            if (AssertUtils.isEmpty(objectNameList)) {
                return;
            }

            if (objectNameList.stream().noneMatch(it -> classDescriber.getSimpleName().equals(it))) {
                return;
            }

            scannedObjects.addAll(javaClasses);

            if (processContext.getConfiguration().isLogServiceDetail()) {
                log.info("发现服务:" + classDescriber.getPackage() + "/" + classDescriber.getSimpleName());
            }
        }
    }
}
