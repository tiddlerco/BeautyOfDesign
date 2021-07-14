package design.adapter.基于组合;

import design.adapter.基于继承.Adaptee;
import design.adapter.基于继承.ITarget;

/**
 * 将 Adaptee 转化成一组符合 ITarget 接口定义的接口
 *
 * @Author 喻可
 * @Date 2021/7/14 10:26
 */
public class Adaptor implements ITarget {

    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        adaptee.fa();//委托给Adaptee

    }

    @Override
    public void f2() {
        //...重新实现f2()...
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}
