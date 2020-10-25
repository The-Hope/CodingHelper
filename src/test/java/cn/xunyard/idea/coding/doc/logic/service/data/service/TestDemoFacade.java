package cn.xunyard.idea.coding.doc.logic.service.data.service;

import cn.xunyard.idea.coding.doc.logic.service.data.service.request.DemoRequestWithComment;
import cn.xunyard.idea.coding.doc.logic.service.data.service.request.DemoRequestWithSwaggerAnnotation;
import cn.xunyard.idea.coding.doc.logic.service.data.service.response.DemoResponseWithComment;
import cn.xunyard.idea.coding.doc.logic.service.data.service.response.DemoResponseWithSwaggerAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 测试demo 接口
 *
 * @author Sivan
 * @version 1.0
 * @date 2020/10/25 10:39 上午
 */
@Api("测试 demo 接口")
public interface TestDemoFacade {

    @ApiOperation("执行某些行为-补充swagger增加注释")
    DemoResponseWithSwaggerAnnotation doSomething(DemoRequestWithSwaggerAnnotation request);

    /**
     * 执行某些行为，补充Java注释
     *
     * @param request 请求对象
     * @return 返回结果
     */
    DemoResponseWithComment doSomething(DemoRequestWithComment request);

}
