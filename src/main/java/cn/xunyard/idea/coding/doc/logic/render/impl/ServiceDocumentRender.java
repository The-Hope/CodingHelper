package cn.xunyard.idea.coding.doc.logic.render.impl;

import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.MethodDescriber;
import cn.xunyard.idea.coding.doc.logic.describer.ServiceDescriber;
import cn.xunyard.idea.coding.doc.logic.render.BaseDocumentRender;
import cn.xunyard.idea.coding.log.Logger;
import cn.xunyard.idea.coding.log.LoggerFactory;
import cn.xunyard.idea.coding.util.AssertUtils;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author <a herf="mailto:wuqi@terminus.io">xunyard</a>
 * @date 2019-12-21
 */
@RequiredArgsConstructor
public class ServiceDocumentRender extends BaseDocumentRender {
    private final Logger log = LoggerFactory.getLogger(ProcessContext.IDENTITY);
    private final ProcessContext processContext;
    private final List<ServiceDescriber> serviceDescriberList;
    private final ParameterRender parameterRender = new ParameterRender();
    private final ResponseRender responseRender = new ResponseRender();

    @Override
    public Logger getLog() {
        return log;
    }

    @Override
    public ProcessContext getProcessContext() {
        return processContext;
    }

    @Override
    public void doRender(BufferedWriter bufferedWriter) throws IOException {
        renderService(bufferedWriter);
    }

    private void renderService(BufferedWriter bufferedWriter) throws IOException {
        // 服务索引
        int serviceIndex = 1;
        for (ServiceDescriber serviceDescriber : serviceDescriberList) {
            renderService(serviceIndex, bufferedWriter, serviceDescriber);
            serviceIndex++;
        }

        bufferedWriter.flush();
    }

    /**
     * 生成接口文档
     *
     * @param serviceIndex     服务索引编号
     * @param fileWriter       文档写入器
     * @param serviceDescriber 服务描述对象
     * @throws IOException io 异常
     */
    private void renderService(int serviceIndex, BufferedWriter fileWriter, ServiceDescriber serviceDescriber)
            throws IOException {

        fileWriter.write(String.format("## " + serviceIndex + ". %s\n\n", serviceDescriber.getDescription()));
        if (!AssertUtils.isEmpty(serviceDescriber.getNote())) {
            fileWriter.write(String.format("接口说明\n%s\n", serviceDescriber.getNote()));
        }

        fileWriter.write(String.format("*接口路径*\n\n**%s**\n", serviceDescriber.getFullName()));
        fileWriter.write("\n\n");
        int serviceMethodIndex = 1;//服务方法索引
        for (MethodDescriber methodDescriber : serviceDescriber.getMethods()) {
            renderMethod(serviceIndex, serviceMethodIndex, fileWriter, methodDescriber);
            serviceMethodIndex++;
        }
    }

    /**
     * 生成接口中方法文档
     * @param serviceIndex
     * @param serviceMethodIndex
     * @param fileWriter
     * @param methodDescriber
     * @throws IOException
     */
    private void renderMethod(int serviceIndex, int serviceMethodIndex, BufferedWriter fileWriter,
                              MethodDescriber methodDescriber)
            throws IOException {

        fileWriter.write(String.format("### " + serviceIndex + "." + serviceMethodIndex + ". %s\n",
                methodDescriber.getDescription()));
        fileWriter.write("\n\n");
        if (!AssertUtils.isEmpty(methodDescriber.getNote())) {
            fileWriter.write(String.format("\n>%s\n\n", methodDescriber.getNote()));
            fileWriter.write("\n\n");
        }

        fileWriter.write(String.format("#### " + serviceIndex + "." + serviceMethodIndex
                + ".1 方法签名\n\n```java\n%s\n```\n", methodDescriber.getSign()));
        fileWriter.write("\n\n");
        if (methodDescriber.hasParameter()) {
            fileWriter.write("#### " + serviceIndex + "." + serviceMethodIndex
                    + ".2 请求参数\n\n");
            parameterRender.renderParameter(fileWriter, methodDescriber.getParameterList().iterator().next());
            fileWriter.write("\n\n");
        }

        if (methodDescriber.hasResponse()) {
            fileWriter.write("#### " + serviceIndex + "." + serviceMethodIndex
                    + ".3 返回参数\n\n");
            responseRender.renderParameter(fileWriter, methodDescriber.getResponse());
            fileWriter.write("\n\n");
        }
    }

    private void renderService(BufferedWriter fileWriter, ServiceDescriber serviceDescriber) throws IOException {

        fileWriter.write(String.format("## %s\n\n", serviceDescriber.getDescription()));

        if (!AssertUtils.isEmpty(serviceDescriber.getNote())) {
            fileWriter.write(String.format("接口说明\n%s\n", serviceDescriber.getNote()));
        }

        fileWriter.write(String.format("*接口路径*\n\n**%s**\n", serviceDescriber.getFullName()));

        for (MethodDescriber methodDescriber : serviceDescriber.getMethods()) {
            renderMethod(fileWriter, methodDescriber);
        }
    }

    private void renderMethod(BufferedWriter fileWriter, MethodDescriber methodDescriber) throws IOException {
        fileWriter.write(String.format("### %s\n", methodDescriber.getDescription()));

        if (!AssertUtils.isEmpty(methodDescriber.getNote())) {
            fileWriter.write(String.format("\n>%s\n\n", methodDescriber.getNote()));
        }

        fileWriter.write(String.format("#### 方法签名\n\n```java\n%s\n```\n", methodDescriber.getSign()));

        if (methodDescriber.hasParameter()) {
            fileWriter.write("#### 请求参数\n\n");

            parameterRender.renderParameter(fileWriter, methodDescriber.getParameterList().iterator().next());
        }


        if (methodDescriber.hasResponse()) {
            fileWriter.write("#### 返回参数\n\n");
            responseRender.renderParameter(fileWriter, methodDescriber.getResponse());
        }
    }

}
