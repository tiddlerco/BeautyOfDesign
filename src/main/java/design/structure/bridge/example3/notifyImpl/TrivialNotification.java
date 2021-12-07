package design.structure.bridge.example3.notifyImpl;




import design.structure.bridge.example3.senderImpl.EmailMsgSender;

import javax.annotation.Resource;

/**
 * @Author 喻可
 * @Date 2021/7/13 10:03
 */
@Resource
public class TrivialNotification extends Notification {

    @Resource
    protected EmailMsgSender msgSender;

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
}