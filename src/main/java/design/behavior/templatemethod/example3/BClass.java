package design.behavior.templatemethod.example3;

/**
 * @Author 喻可
 * @Date 2021/8/12 9:37
 */
public class BClass {

    public void process(ICallback callback) {
        //...
        System.out.println("回调开始");
        callback.methodToCallback();
        System.out.println("回调结束");
        // ...
    }
}
