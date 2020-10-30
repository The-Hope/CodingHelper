package cn.xunyard.idea.coding.doc.logic.service;

import cn.xunyard.idea.coding.doc.logic.DocumentBuilderConfiguration;
import cn.xunyard.idea.coding.doc.logic.service.shim.MyLogger;
import cn.xunyard.idea.coding.util.ProjectUtils;
import com.intellij.openapi.project.Project;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * TODO
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/24 7:15 下午
 */
public class ServiceAsyncProcessorTest {

    @Before
    public void setUp() {
        // mock logger
        new MyLogger();
    }

    @Test
    public void run() {

        // mock project
        Project mock = Mockito.mock(Project.class);
        Mockito.when(mock.getBasePath()).thenReturn("/Users/terminus/IdeaProjects/CodingHelper/src/test/java/cn/xunyard/idea/coding/doc/logic/service/data");
        ProjectUtils.switchProject(mock);
        // mock 输出目录
        String outputPath = "/Users/terminus/IdeaProjects/CodingHelper/src/test/java/cn/xunyard/idea/coding/doc/logic/service/data/output/service";
        DocumentBuilderConfiguration configuration = new DocumentBuilderConfiguration();
        configuration.setOutputDirectory(outputPath);

        ServiceAsyncProcessor processor = new ServiceAsyncProcessor(
                configuration,
                ProjectUtils.getCurrentProject(),
                this::doDone);

        processor.run();

    }

    private void doDone(DocumentBuilderConfiguration configuration) {

    }

}