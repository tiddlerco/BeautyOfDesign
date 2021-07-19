package design.behavior.observer.springevent.listener;

import design.behavior.observer.springevent.eventclass2.AccountCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author 喻可
 * @Date 2021/7/19 12:00
 */
@Component
public class AccountListener {

    @Async
    @EventListener
    public void sendEmailOnAccountCreatedEvent(AccountCreatedEvent event) {
        // 发送邮件
        // do something else
    }
}
