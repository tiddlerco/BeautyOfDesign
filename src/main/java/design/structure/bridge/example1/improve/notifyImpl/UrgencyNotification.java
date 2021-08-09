package design.structure.bridge.example1.improve.notifyImpl;

import design.structure.bridge.example1.improve.senderImpl.MsgSender;
import design.structure.bridge.example1.improve.Notification;

/**
 * @Author 喻可
 * @Date 2021/7/13 10:00
 */
public class UrgencyNotification extends Notification {

    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
