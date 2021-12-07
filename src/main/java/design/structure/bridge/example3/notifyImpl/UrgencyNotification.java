package design.structure.bridge.example3.notifyImpl;



import design.structure.bridge.example3.senderImpl.WechatMsgSender;

import javax.annotation.Resource;

/**
 * @Author 喻可
 * @Date 2021/7/13 10:00
 */
@Resource
public class UrgencyNotification extends Notification {

    @Resource
    protected WechatMsgSender msgSender;

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}
