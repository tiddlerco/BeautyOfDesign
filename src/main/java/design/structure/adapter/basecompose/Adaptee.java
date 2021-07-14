package design.structure.adapter.basecompose;

/**
 * 一组不兼容 ITarget 接口定义的接口
 *
 * 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都相同，
 * 那我们推荐使用类适配器，因为 Adaptor 复用父类 Adaptee 的接口，
 * 比起对象适配器的实现方式，Adaptor 的代码量要少一些。
 * @Author 喻可
 * @Date 2021/7/14 10:25
 */
public class Adaptee {

    public void fa() {
        //...
    }

    public void fb() {

    }

    public void fc() {

    }
}
