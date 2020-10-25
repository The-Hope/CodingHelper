package cn.xunyard.idea.coding.doc.logic.service.data.service.request;

import lombok.Data;

/**
 * demo 请求-字段添加 swagger 注解
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/25 10:56 上午
 */
@Data
public class DemoRequestWithComment {

    /**
     * 某种过滤条件
     */
    private String someCondition;
}
