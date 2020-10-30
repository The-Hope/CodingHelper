package cn.xunyard.idea.coding.doc.logic.object;

import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.ServiceDescriber;
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

    private final List<JavaClass> objectClasses;
    private final ProcessContext processContext;
    @Getter
    private List<ServiceDescriber> serviceDescriberList;

    public static void setResolveFail() {
        RESOLVE_OK.set(false);
    }

    public ObjectResolver(List<JavaClass> objectClasses, ProcessContext processContext) {
        this.objectClasses = objectClasses;
        this.processContext = processContext;

        serviceDescriberList = new ArrayList<>(objectClasses.size());
    }

    public boolean run() {
        RESOLVE_OK.set(true);
        log.info("开始解析服务...");
        if (AssertUtils.isEmpty(objectClasses)) {
            log.error("未发现有效服务");
            return false;
        }

        for (JavaClass javaClass : objectClasses) {
            ServiceDescriber serviceDescriber = processContext.getServiceDescriberMaker().fromJavaClass(javaClass);

            if (serviceDescriber != null) {
                serviceDescriberList.add(serviceDescriber);
            }
        }
        log.info("服务解析完成");

        boolean isOk = RESOLVE_OK.get();
        RESOLVE_OK.remove();
        return isOk;
    }
}
