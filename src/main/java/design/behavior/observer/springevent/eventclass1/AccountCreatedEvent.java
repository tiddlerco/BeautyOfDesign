package design.behavior.observer.springevent.eventclass1;

import design.behavior.observer.springevent.entity.AccountEventData;

/**
 * @Author 喻可
 * @Date 2021/7/19 10:30
 */
public class AccountCreatedEvent extends AccountEvent {
    public AccountCreatedEvent(Object source, AccountEventData eventData) {
        super(source, eventData);
    }
}
