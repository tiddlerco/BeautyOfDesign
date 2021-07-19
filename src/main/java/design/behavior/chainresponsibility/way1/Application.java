package design.behavior.chainresponsibility.way1;

/**
 * @Author 喻可
 * @Date 2021/7/19 16:34
 */


// 使用举例
public class Application {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handle();
    }
}
