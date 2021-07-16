package design.behavior.observer.mostcommonexample.observer;

import design.behavior.observer.mostcommonexample.entity.Message;

/**
 * 观察者
 *
 * @Author 喻可
 * @Date 2021/7/16 14:03
 */
public interface Observer {
    void update(Message message);
}