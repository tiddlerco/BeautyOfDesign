package design.behavior.observer.springevent.publisher;

/**
 * 方式1：直接使用ApplicationEventPublisher(推荐)
 *
 * @Author 喻可
 * @Date 2021/7/19 10:45
 */

import design.behavior.observer.springevent.entity.Account;
import design.behavior.observer.springevent.entity.AccountEventData;
import design.behavior.observer.springevent.eventclass2.AccountCreatedEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AccountsController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("")
    public Account createAccount(@RequestBody Account account) {

        AccountEventData accountEventData = new AccountEventData();

        BeanUtils.copyProperties(account, accountEventData);

        publisher.publishEvent(new AccountCreatedEvent(this, accountEventData));

        return account;
    }

}
