package cn.xunyard.idea.coding.doc.logic.service.data.service.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * demo 响应-字段添加 swagger 注解
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/25 10:43 上午
 */
@Data
public class DemoResponseWithSwaggerAnnotation {

    @ApiModelProperty("某种响应")
    private String anyResponse;

}
