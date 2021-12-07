package design.structure.bridge.example3.senderImpl;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/7/13 9:54
 */
@Resource
public class TelephoneMsgSender implements MsgSender {

    private List telephones;


    @Override
    public void send(String message) {
        System.out.println("电话发送消息");
    }
}