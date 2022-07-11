package design.behavior.templatemethod.example5;

/**
 * @title: CPCNchannelPay
 * @Author yuke
 * @Date: 2022/6/1 21:30
 */
public class CPCNchannelPay extends AbstractBasePay{

    @Override
    void channlPay() {
        System.out.println("中金支付");
    }

    boolean isCheckAuth() {
        return false;
    }
}
