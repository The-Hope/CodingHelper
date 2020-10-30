package cn.xunyard.idea.coding.doc.logic.service;

import cn.xunyard.idea.coding.constant.errorcode.CommonErrorCodeMap;
import cn.xunyard.idea.coding.constant.exception.ServiceException;
import cn.xunyard.idea.coding.doc.logic.DocumentBuilderConfiguration;
import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.ServiceDescriber;
import cn.xunyard.idea.coding.doc.logic.render.impl.ServiceDocumentRender;
import cn.xunyard.idea.coding.log.Logger;
import cn.xunyard.idea.coding.log.LoggerFactory;
import cn.xunyard.idea.coding.util.AssertUtils;
import com.intellij.openapi.project.Project;
import com.thoughtworks.qdox.model.JavaClass;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 异步文档生成处理器
 *
 * @author <a herf="mailto:wuqi@terminus.io">xunyard</a>
 * @date 2019-12-29
 */
@RequiredArgsConstructor
public class ServiceAsyncProcessor extends BaseAsyncProcessor implements Runnable {
    private final Logger log = LoggerFactory.getLogger(ProcessContext.IDENTITY);
    private final DocumentBuilderConfiguration configuration;
    private final Project project;
    private final Consumer<DocumentBuilderConfiguration> doneCallBack;

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

            ServiceScanner serviceScanner = new ServiceScanner(processContext);
            List<JavaClass> serviceJavaClassList = serviceScanner.scan(basePath);
            if (AssertUtils.isEmpty(serviceJavaClassList)) {
                getLog().error("过程终止，未发现有效源文件路径!");
                return;
            }

            ServiceResolver serviceResolver = new ServiceResolver(serviceJavaClassList, processContext);
            if (!serviceResolver.run() && !getConfiguration().isAllowInfoMissing()) {
                throw new ServiceException(CommonErrorCodeMap.STOP_BY_LACK_COMMENT);
            }
            List<ServiceDescriber> serviceDescriberList = serviceResolver.getServiceDescriberList();

            ServiceDocumentRender serviceDocumentRender = new ServiceDocumentRender(processContext, serviceDescriberList);
            serviceDocumentRender.run();
        } catch (ServiceException e) {
            getLog().error(e.getMessage());
        } catch (Throwable e) {
            getLog().error("fail to run, cause: " + formatException(e));
        } finally {
            processContext.clear();
        }
    }

    @Override
    protected Logger getLog() {
        return log;
    }
}
