package design.behavior.templatemethod.example3;

/**
 * 如果某个类中定义了多个模板方法，每个方法都有对应的抽象方法，
 * 那即便我们只用到其中的一个模板方法，子类也必须实现所有的抽象方法。
 * 而回调就更加灵活，我们只需要往用到的模板方法中注入回调对象即可。
 * <p>
 * 可以理解为把模板模式中的多个模板方法拆分为多个回调接口吗？
 *
 * @Author 喻可
 * @Date 2021/8/12 9:38
 */
public class AClass {

    public static void main(String[] args) {
        BClass b = new BClass();
        //同步回调
        //同步回调看起来更像模板模式，异步回调看起来更像观察者模式
        b.process(new ICallback() { //回调对象
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
