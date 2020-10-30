package cn.xunyard.idea.coding.doc.logic.service;

import cn.xunyard.idea.coding.doc.logic.DocumentBuilderConfiguration;
import cn.xunyard.idea.coding.log.Logger;
import com.intellij.openapi.project.Project;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/26 8:29 上午
 */
public abstract class BaseAsyncProcessor {
    public void run() {
        run(getProject().getBasePath());
        getDoneCallBack().accept(getConfiguration());
    }

    protected abstract Consumer<DocumentBuilderConfiguration> getDoneCallBack();

    protected abstract DocumentBuilderConfiguration getConfiguration();

    protected abstract Project getProject();

    public abstract void run(String basePath);

    protected String formatException(Throwable e) {
        String message = e.toString();
        String str = Arrays.stream(e.getStackTrace()).map(Objects::toString).collect(Collectors.joining("\n"));
        return message + "\n" + str;
    }

    /**
     * 校验输出文件夹是否合法
     *
     * @return 是否文件夹非有效目录或已存在并无法删除
     */
    protected boolean checkOutput() {
        String outputDirectory = getConfiguration().getOutputDirectory();
        File file = new File(outputDirectory);
        try {
            if (!file.exists() || !file.isDirectory()) {
                getLog().error("错误: " + outputDirectory + " 不是有效的目录");
                return false;
            }

            String fullPath = outputDirectory + "/" + getConfiguration().getOutputFileName();
            File outputFile = new File(fullPath);
            if (outputFile.exists()) {
                getLog().warn("检测到输出文件已存在，删除!");
                boolean isOk = outputFile.delete();

                if (!isOk) {
                    getLog().error("错误: " + fullPath + " 无法删除");
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            getLog().error("检测到错误: " + formatException(e));
            return false;
        }
    }

    /**
     * 获取日志打印器
     * @return 日志打印器
     */
    protected abstract Logger getLog();
}
