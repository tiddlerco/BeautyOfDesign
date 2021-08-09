package design.structure.bridge.example1.improve.senderImpl;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/13 9:55
 */
public class EmailMsgSender implements MsgSender {

    private List emailAddresses;

    public EmailMsgSender(List emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public void send(String message) {
        //...
    }
}
