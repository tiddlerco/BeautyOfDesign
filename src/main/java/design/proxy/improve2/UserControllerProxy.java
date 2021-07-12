package design.proxy.improve2;

import countapi.rebuild1.build.MetricsCollector;
import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.UserVo;

/**
 * 如果原始类并没有定义接口，并且原始类代码并不是我们开发维护的（比如它来自一个第三方的类库）
 * 我们也没办法直接修改原始类
 * 对于这种外部类的扩展，我们一般都是采用继承的方式
 *
 * @Author 喻可
 * @Date 2021/7/12 10:50
 */

public class UserControllerProxy extends UserController {
    private MetricsCollector metricsCollector;

    public UserControllerProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }

    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = super.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }
}

//UserControllerProxy使用举例
// UserController userController = new UserControllerProxy();
