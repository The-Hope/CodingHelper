package cn.xunyard.idea.coding.doc.logic.render.impl;

import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.doc.logic.describer.ClassDescriber;
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
 * 对象文档渲染器
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/26 8:20 上午
 */
@RequiredArgsConstructor
public class ObjectDocumentRender extends BaseDocumentRender {

    private final Logger log = LoggerFactory.getLogger(ProcessContext.IDENTITY);
    private final ObjectRender objectRender = new ObjectRender();
    private final ProcessContext processContext;
    private final List<ClassDescriber> objectDescriberList;

    @Override
    public void doRender(BufferedWriter bufferedWriter) throws IOException {
        // 服务索引
        int objectIndex = 1;
        for (ClassDescriber classDescriber : objectDescriberList) {
            renderObject(objectIndex, bufferedWriter, classDescriber);
            objectIndex++;
        }

        bufferedWriter.flush();
    }

    private void renderObject(int objectIndex, BufferedWriter fileWriter, ClassDescriber classDescriber) throws IOException {
        fileWriter.write(String.format("### " + objectIndex + ". %s\n\n", classDescriber.getDescription()));
        if (!AssertUtils.isEmpty(classDescriber.getNote())) {
            fileWriter.write(String.format("参数说明\n%s\n", classDescriber.getNote()));
        }

        fileWriter.write(String.format("*参数路径*\n\n**%s**\n", classDescriber.getFullName()));
        fileWriter.write("\n\n");
        objectRender.renderObject(fileWriter, classDescriber);
    }

    @Override
    public Logger getLog() {
        return this.log;
    }

    @Override
    public ProcessContext getProcessContext() {
        return this.processContext;
    }
}
