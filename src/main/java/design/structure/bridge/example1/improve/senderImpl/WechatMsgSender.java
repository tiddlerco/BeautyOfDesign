package design.structure.bridge.example1.improve.senderImpl;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/13 9:55
 */
public class WechatMsgSender implements MsgSender {

    private List wechatIds;

    public WechatMsgSender(List wechatIds) {
        this.wechatIds = wechatIds;
    }

    @Override
    public void send(String message) {
        //...
    }
}
