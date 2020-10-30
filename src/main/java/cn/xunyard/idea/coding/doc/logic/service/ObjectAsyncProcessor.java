package cn.xunyard.idea.coding.doc.logic.service;

import cn.xunyard.idea.coding.constant.errorcode.CommonErrorCodeMap;
import cn.xunyard.idea.coding.constant.exception.ServiceException;
import cn.xunyard.idea.coding.doc.logic.DocumentBuilderConfiguration;
import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.ClassDescriber;
import cn.xunyard.idea.coding.doc.logic.describer.ServiceDescriber;
import cn.xunyard.idea.coding.doc.logic.object.ObjectScanner;
import cn.xunyard.idea.coding.doc.logic.render.impl.ObjectDocumentRender;
import cn.xunyard.idea.coding.doc.logic.render.impl.ServiceDocumentRender;
import cn.xunyard.idea.coding.log.Logger;
import cn.xunyard.idea.coding.log.LoggerFactory;
import cn.xunyard.idea.coding.util.AssertUtils;
import com.intellij.openapi.project.Project;
import com.thoughtworks.qdox.model.JavaClass;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Consumer;

/**
 * TODO
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/26 8:45 上午
 */
@RequiredArgsConstructor
public class ObjectAsyncProcessor extends BaseAsyncProcessor{
    private final Logger log = LoggerFactory.getLogger(ProcessContext.IDENTITY);
    private final DocumentBuilderConfiguration configuration;
    private final Project project;
    private final Consumer<DocumentBuilderConfiguration> doneCallBack;


    @Override
    protected Logger getLog() {
        return log;
    }

    @Override
    protected Consumer<DocumentBuilderConfiguration> getDoneCallBack() {
        return doneCallBack;
    }

    @Override
    protected DocumentBuilderConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    protected Project getProject() {
        return project;
    }

    @Override
    public void run(String basePath) {
        if (!checkOutput()) {
            return;
        }

        ProcessContext processContext = new ProcessContext(getConfiguration());
        try {
            processContext.init();

            ObjectScanner objectScanner = new ObjectScanner(processContext);
            List<JavaClass> serviceJavaClassList = objectScanner.scan(basePath);
            if (AssertUtils.isEmpty(serviceJavaClassList)) {
                log.error("过程终止，未发现有效源文件路径!");
                return;
            }

            ObjectResolver serviceResolver = new ObjectResolver(serviceJavaClassList, processContext);
            if (!serviceResolver.run() && !getConfiguration().isAllowInfoMissing()) {
                throw new ServiceException(CommonErrorCodeMap.STOP_BY_LACK_COMMENT);
            }
            List<ClassDescriber> describerList = serviceResolver.getObjectDescriberList();

            ObjectDocumentRender objectDocumentRender = new ObjectDocumentRender(processContext, describerList);
            objectDocumentRender.run();
        } catch (ServiceException e) {
            log.error(e.getMessage());
        } catch (Throwable e) {
            log.error("fail to run, cause: " + formatException(e));
        } finally {
            processContext.clear();
        }
    }
}
