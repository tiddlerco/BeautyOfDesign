package design.behavior.observer.mostcommonexample.subject;

import design.behavior.observer.mostcommonexample.entity.Message;
import design.behavior.observer.mostcommonexample.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者中持有观察者的对象集合
 *
 * @Author 喻可
 * @Date 2021/7/16 14:02
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

}
