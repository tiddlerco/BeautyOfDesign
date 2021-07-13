package design.bridge.improve.notifyImpl;

import design.bridge.improve.MsgSender;
import design.bridge.improve.Notification;

/**
 * @Author 喻可
 * @Date 2021/7/13 9:57
 */
public class SevereNotification extends Notification {
    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
