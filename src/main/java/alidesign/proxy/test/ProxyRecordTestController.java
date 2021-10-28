package alidesign.proxy.test;

import alidesign.proxy.aopframe.annotation.InvokeRecordAnno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/10/28 15:12
 */
@RestController
@RequestMapping("proxy")
public class ProxyRecordTestController {

    @GetMapping("test")
    @InvokeRecordAnno("测试代理模式")
    public Map<String, Object> testProxy(@RequestParam String biz,
                                         @RequestParam String param) {
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("nick", "之叶");

        return result;
    }
}
//测试代理模式 执行结束，耗时=5ms,入参=["abc","test"
// ],出参={"nick"："之叶","id":"123"}
