package design.structure.bridge.example3.notifyImpl;


import design.structure.bridge.example3.senderImpl.TelephoneMsgSender;

import javax.annotation.Resource;

/**
 * @Author 喻可
 * @Date 2021/7/13 10:01
 */
@Resource
public class NormalNotification extends Notification {

    @Resource
    protected TelephoneMsgSender msgSender;

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
