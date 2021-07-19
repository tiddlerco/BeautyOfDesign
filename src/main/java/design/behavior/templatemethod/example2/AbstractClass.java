package design.behavior.templatemethod.example2;

/**
 * 假设一个框架中的某个类暴露了两个模板方法，
 * 并且定义了一堆供模板方法调用的抽象方法
 * 在项目开发中，即便我们只用到这个类的其中一个模板方法，
 * 我们还是要在子类中把所有的抽象方法都实现一遍
 * <p>
 * 解决：写个适配器，把所有抽象方法默认实现一下，子类继承这个 adapter
 *
 * @Author 喻可
 * @Date 2021/7/19 15:10
 */

public abstract class AbstractClass {


    public final void templateMethod1() {
        //...
        method1();
        //...
        method2();
        //...
    }

    public final void templateMethod2() {
        //...
        method3();
        //...
        method4();
        //...
    }

    protected abstract void method1();

    protected abstract void method2();

    protected abstract void method3();

    protected abstract void method4();
}
