package design.structure.adapter.application.example1;

/**
 * 基于继承
 *
 * @Author 喻可
 * @Date 2021/7/14 10:55
 */

// 注意：适配器类的命名不一定非得末尾带Adaptor
public class CDAdaptor extends CD implements ITarget {

    //CD类里的static方法变成非静态的
    @Override
    public void function1() {
        super.staticFunction1();
    }

    @Override
    public void function2() {
        super.uglyNamingFunction2();
    }

    @Override
    public void fucntion3(String paramsWrapper) {
        super.tooManyParamsFunction3(paramsWrapper);
    }

    @Override
    public void function4() {
        //...reimplement it...
    }
}