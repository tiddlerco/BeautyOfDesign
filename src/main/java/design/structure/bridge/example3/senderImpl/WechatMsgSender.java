package design.structure.bridge.example3.senderImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/13 9:55
 */
@Resource
public class WechatMsgSender implements MsgSender {

    private List wechatIds;


    @Override
    public void send(String message) {
        System.out.println("微信发送消息");
    }
}
