package design.behavior.observer.springevent.listener;

import design.behavior.observer.springevent.eventclass2.AccountCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author 喻可
 * @Date 2021/7/19 11:03
 */
@Slf4j
@Component
public class SyncAccountListener {

    /**
     * 异步发送邮件
     *
     * @param event
     */
    @EventListener
    public void doOnNormalEvent(AccountCreatedEvent event) {
        try {

            //service.save(event);

            log.debug("befor");
            Thread.sleep(1000);
            log.debug("after");
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
}
