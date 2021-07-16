package design.behavior.observer.mostcommonexample.subject;

import design.behavior.observer.mostcommonexample.entity.Message;
import design.behavior.observer.mostcommonexample.observer.Observer;

/**
 * 被观察者
 *
 * @Author 喻可
 * @Date 2021/7/16 14:01
 */

public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     * @param message
     */
    void notifyObservers(Message message);
}










