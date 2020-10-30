package cn.xunyard.idea.coding.doc.logic.render;

import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.log.Logger;
import com.google.common.base.Throwables;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 文档渲染基类
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/26 7:19 上午
 */
public abstract class BaseDocumentRender {

    /**
     * 渲染功能入口
     * @throws IOException 读写异常
     */
    public void run() throws IOException {
        this.getLog().info("开始生成文档...");
        String filepath = this.getProcessContext().getConfiguration().getOutputDirectory() + "/" +
                this.getProcessContext().getConfiguration().getOutputFileName();
        try (FileOutputStream fos = new FileOutputStream(filepath, false)) {
            try (OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
                try (BufferedWriter bufferedWriter = new BufferedWriter(osw)) {
                    doRender(bufferedWriter);
                    this.getLog().info(String.format("文档生成完成，文档路径: %s", filepath));
                } catch (Exception e) {
                    this.getLog().error("文档生成失败: {}", Throwables.getStackTraceAsString(e));
                }
            } catch (Exception e) {
                this.getLog().error("文件准备失败: {}", Throwables.getStackTraceAsString(e));
            }
        } catch (Exception e) {
            this.getLog().error("根节点失败: {}", Throwables.getStackTraceAsString(e));
        }
    }

    /**
     * 执行渲染
     * @param bufferedWriter 字节流
     * @throws IOException 读写异常
     */
    public abstract void doRender(BufferedWriter bufferedWriter) throws IOException;

    /**
     * 获取日志
     * @return 返回日志记录器
     */
    public abstract Logger getLog();

    /**
     * 获取处理器上下文
     * @return 返回处理器上下文
     */
    public abstract ProcessContext getProcessContext();
}
