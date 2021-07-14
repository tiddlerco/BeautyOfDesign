package design.structure.bridge.improve.notifyImpl;

import design.structure.bridge.improve.MsgSender;
import design.structure.bridge.improve.Notification;

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
