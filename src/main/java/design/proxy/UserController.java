package design.proxy;

import countapi.rebuild1.build.MetricsCollector;
import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.UserVo;

/**
 * 问题1：性能计数器框架代码侵入到业务代码中，跟业务代码高度耦合
 * 问题2: 收集接口请求的代码跟业务代码无关，本就不应该放到一个类中
 *
 * @Author 喻可
 * @Date 2021/7/12 10:37
 */

public class UserController {
    //...省略其他属性和方法...
    private MetricsCollector metricsCollector; // 依赖注入

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // ... 省略login逻辑...

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        //...返回UserVo数据...
        return null;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // ... 省略register逻辑...

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        //...返回UserVo数据...
        return null;
    }
}
