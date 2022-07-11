package design.behavior.templatemethod.example5;

/**
 * @title: AliChannelPay
 * @Author yuke
 * @Date: 2022/6/1 21:31
 */
public class AliChannelPay extends AbstractBasePay{

    @Override
    void channlPay() {
        System.out.println("阿里pay");
    }

}
