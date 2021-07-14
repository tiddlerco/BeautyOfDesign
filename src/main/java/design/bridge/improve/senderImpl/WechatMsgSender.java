package design.bridge.improve.senderImpl;

import design.bridge.improve.MsgSender;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/13 9:55
 */
public class WechatMsgSender implements MsgSender {

    private List telephones;

    public WechatMsgSender(List telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        //...
    }
}