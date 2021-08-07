package design.structure.proxy.annotationAop;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 利用AOP实现自定义注解
 *
 * @description: 定义AOP切面
 * @author: 喻可
 * @create: 2021-08-07
 **/
@RestController
public class TestAction {

    @EagleEye(desc = "测试接口")
    @RequestMapping(value = "/sayHello")
    public String test(String params)throws Exception{
        System.out.println("参数:" + params);
        return "hello "+ params;
    }

//    请求路径 : http://127.0.0.1:8081/aop-demo/sayHello
//    请求方式 : GET
//    方法名 : test
//    类路径 : com.asiainfo.action.TestAction
//    参数 : [lala]
//    环绕通知开始...
//    参数:lala
//    方法环绕proceed，结果是 :hello lala


}

