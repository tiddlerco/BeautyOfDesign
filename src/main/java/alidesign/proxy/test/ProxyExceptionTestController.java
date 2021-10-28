package alidesign.proxy.test;

import alidesign.proxy.aopframe.annotation.ExceptionHandleAnno;
import alidesign.proxy.aopframe.annotation.InvokeRecordAnno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 能同时代理两种注解
 *
 * @Author 喻可
 * @Date 2021/10/28 16:05
 */
@RestController
@RequestMapping("proxy")
public class ProxyExceptionTestController {

    @GetMapping("test")
    @ExceptionHandleAnno
    @InvokeRecordAnno("测试代理模式")
    public Map<String, Object> testProxy(@RequestParam String biz,
                                         @RequestParam String param) {
        if (biz.equals("abc")) {
            throw new IllegalArgumentException("非法的 biz=" + biz);
        }

        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("nick", "之叶");

        return result;
    }
    //执行效果在readme中查看
}
