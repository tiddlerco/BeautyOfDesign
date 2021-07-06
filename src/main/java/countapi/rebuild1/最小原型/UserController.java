package countapi.rebuild1.最小原型;

import countapi.rebuild1.entity.UserVo;

import java.util.concurrent.TimeUnit;

/**
 * @Author 喻可
 * @Date 2021/6/30 16:35
 */

//应用场景：统计下面两个接口(注册和登录）的响应时间和访问次数
public class UserController {
    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    public void register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("regsiter", startTimestamp);
        //...
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }

    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        //...
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
        return null;
    }
}
