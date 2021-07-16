package design.behavior.observer.example;

import design.behavior.observer.example.observer.RegObserver;
import design.behavior.observer.example.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 使用观察者模式
 * <p>
 * 需求频繁变动，比如，用户注册成功之后，不再发放体验金，
 * 而是改为发放优惠券，并且还要给用户发送一封“欢迎注册成功”的站内信
 *
 * @Author 喻可
 * @Date 2021/7/16 14:42
 */
public class UserController2 {

    private UserService userService; // 依赖注入

    private List<RegObserver> regObservers = new ArrayList<>();

    // 一次性设置好，之后也不可能动态的修改
    //添加观察者 什么时候调用这个方法呢？
    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password) {
        //省略输入参数的校验代码
        //省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);


        //被观察逻辑  这里是同步阻塞通知，可以换成异步
        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        //异步阻塞通知的实现方式
        List<CompletableFuture> futures = new ArrayList();
        for (RegObserver observer : regObservers) {
            futures.add(CompletableFuture.runAsync(() ->
                    observer.handleRegSuccess(userId)
            ));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();


        return userId;
    }

    public static void main(String[] args) {

        List<Integer> lists = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lists.add(i);
        }
        System.out.println("start");

        for (Integer list : lists) {
            CompletableFuture.runAsync(() -> System.out.println(list));
        }

        System.out.println("end");

    }

}
