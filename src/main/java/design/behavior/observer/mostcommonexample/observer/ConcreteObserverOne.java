package design.behavior.observer.mostcommonexample.observer;

import design.behavior.observer.mostcommonexample.entity.Message;

/**
 * @Author 喻可
 * @Date 2021/7/16 14:01
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverOne is notified.");
    }
}
