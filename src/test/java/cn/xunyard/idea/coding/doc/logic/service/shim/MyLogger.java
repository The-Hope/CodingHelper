package cn.xunyard.idea.coding.doc.logic.service.shim;

import cn.xunyard.idea.coding.doc.logic.ProcessContext;
import cn.xunyard.idea.coding.log.Logger;
import cn.xunyard.idea.coding.log.LoggerFactory;

import java.util.HashMap;

/**
 * 测试日志处理类
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/25 11:33 上午
 */
public class MyLogger extends LoggerFactory implements Logger {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyLogger.class);

    /**
     * 构造器中替换默认 logger 实现
     */
    public MyLogger() {
        super();
        if (loggerMap == null) {
            loggerMap = new HashMap<>();
        }
        loggerMap.put(ProcessContext.IDENTITY, this);
    }

    @Override
    public void clear() {
    }

    @Override
    public void debug(String format, Object... args) {
        log.debug(format, args);
    }

    @Override
    public void info(String format, Object... args) {
        log.info(format, args);
    }

    @Override
    public void warn(String format, Object... args) {
        log.warn(format, args);
    }

    @Override
    public void error(String format, Object... args) {
        log.error(format, args);
    }

    @Override
    public void done() {
    }
}
