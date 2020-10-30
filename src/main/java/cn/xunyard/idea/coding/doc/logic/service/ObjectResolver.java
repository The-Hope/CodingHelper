package cn.xunyard.idea.coding.doc.logic.service;

import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.ClassDescriber;
import cn.xunyard.idea.coding.log.Logger;
import cn.xunyard.idea.coding.log.LoggerFactory;
import cn.xunyard.idea.coding.util.AssertUtils;
import com.thoughtworks.qdox.model.JavaClass;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a herf="mailto:wuqi@terminus.io">xunyard</a>
 * @date 2019-12-15
 */
public class ObjectResolver {
    private final Logger log = LoggerFactory.getLogger(ProcessContext.IDENTITY);
    private static final ThreadLocal<Boolean> RESOLVE_OK = new ThreadLocal<>();

    private final List<JavaClass> javaClasses;
    private final ProcessContext processContext;
    @Getter
    private final List<ClassDescriber> objectDescriberList;

    public static void setResolveFail() {
        RESOLVE_OK.set(false);
    }

    public ObjectResolver(List<JavaClass> javaClasses, ProcessContext processContext) {
        this.javaClasses = javaClasses;
        this.processContext = processContext;

        objectDescriberList = new ArrayList<>(javaClasses.size());
    }

    public boolean run() {
        RESOLVE_OK.set(true);
        log.info("开始解析服务...");
        if (AssertUtils.isEmpty(javaClasses)) {
            log.error("未发现有效服务");
            return false;
        }

        for (JavaClass javaClass : javaClasses) {
            ClassDescriber serviceDescriber = processContext.getClassDescriberMaker().fromClass(javaClass);

            objectDescriberList.add(serviceDescriber);
        }
        log.info("服务解析完成");

        boolean isOk = RESOLVE_OK.get();
        RESOLVE_OK.remove();
        return isOk;
    }
}
