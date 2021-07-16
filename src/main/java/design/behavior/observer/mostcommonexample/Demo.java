package design.behavior.observer.mostcommonexample;

import design.behavior.observer.mostcommonexample.entity.Message;
import design.behavior.observer.mostcommonexample.observer.ConcreteObserverOne;
import design.behavior.observer.mostcommonexample.observer.ConcreteObserverTwo;
import design.behavior.observer.mostcommonexample.subject.ConcreteSubject;

/**
 * @Author 喻可
 * @Date 2021/7/16 14:03
 */
public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}
