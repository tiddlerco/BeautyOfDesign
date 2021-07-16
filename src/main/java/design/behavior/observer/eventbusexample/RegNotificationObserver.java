package design.behavior.observer.eventbusexample;

import com.google.common.eventbus.Subscribe;
import design.behavior.observer.example.observer.NotificationService;

/**
 * @Author 喻可
 * @Date 2021/7/16 16:36
 */
public class RegNotificationObserver {

    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "...");
    }
}
