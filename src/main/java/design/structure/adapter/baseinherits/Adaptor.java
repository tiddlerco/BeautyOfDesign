package design.structure.adapter.baseinherits;

/**
 * 将 Adaptee 转化成一组符合 ITarget 接口定义的接口
 *
 * @Author 喻可
 * @Date 2021/7/14 10:26
 */
public class Adaptor extends Adaptee implements ITarget {

    public void f1() {
        super.fa();
    }

    public void f2() {
        //...重新实现f2()...
    }

    // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
}
