package cn.xunyard.idea.coding.constant.exception;

/**
 * 业务异常基类
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/26 8:38 上午
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
