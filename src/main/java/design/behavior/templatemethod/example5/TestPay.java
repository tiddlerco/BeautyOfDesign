package design.behavior.templatemethod.example5;

/**
 * @title: TestPay
 * @Author yuke
 * @Date: 2022/6/1 21:31
 */
public class TestPay {
    public static void main(String[] args) {
        System.out.println("--中金支付start");
        BasePay pay1 = new CPCNchannelPay();
        pay1.mobilePay();
        System.out.println("--中金支付end");


        System.out.println("--阿里paystart");
        BasePay pay2 = new AliChannelPay();
        pay2.mobilePay();
        System.out.println("--阿里payend");

    }
}
