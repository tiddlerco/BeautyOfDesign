package design.behavior.observer.example.observer;

/**
 * 观察者
 * @Author 喻可
 * @Date 2021/7/16 14:41
 */
public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService;

    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
}

