package design.behavior.observer.example;

import design.behavior.observer.example.service.PromotionService;
import design.behavior.observer.example.service.UserService;

/**
 * 未使用观察者模式的使用示例
 * 用户注册成功之后，我们会给用户发放投资体验金
 *
 * @Author 喻可
 * @Date 2021/7/16 14:35
 */

public class UserController {
    private UserService userService; // 依赖注入
    private PromotionService promotionService; // 依赖注入

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);
        promotionService.issueNewUserExperienceCash(userId);
        return userId;
    }
}
