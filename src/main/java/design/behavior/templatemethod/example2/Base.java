package design.behavior.templatemethod.example2;

/**
 * 适配器
 *
 * @Author 喻可
 * @Date 2021/7/19 15:10
 */
public class Base extends AbstractClass {

    @Override
    protected void method1() {
        System.out.println("1");
    }

    @Override
    protected void method2() {
        System.out.println("2");
    }

    @Override
    protected void method3() {
        System.out.println("3");
    }

    @Override
    protected void method4() {
        System.out.println("4");
    }
}

