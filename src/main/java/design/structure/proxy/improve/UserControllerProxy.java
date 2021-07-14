package design.structure.proxy.improve;

import countapi.rebuild1.build.MetricsCollector;
import countapi.rebuild1.entity.RequestInfo;
import countapi.rebuild1.entity.UserVo;
import design.structure.proxy.dynamic.IUserController;

/**
 * 代理类 UserControllerProxy 负责在业务代码执行前后附加其他逻辑代码，
 * 并通过委托的方式调用原始类来执行业务代码
 *
 * @Author 喻可
 * @Date 2021/7/12 10:41
 */
public class UserControllerProxy implements IUserController {
    private MetricsCollector metricsCollector;
    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        // 委托
        UserVo userVo = userController.login(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();

        UserVo userVo = userController.register(telephone, password);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        RequestInfo requestInfo = new RequestInfo("register", responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        return userVo;
    }
}

//UserControllerProxy使用举例
// 因为原始类和代理类实现相同的接口，是基于接口而非实现编程
// 将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
//IUserController userController = new UserControllerProxy(new UserController());