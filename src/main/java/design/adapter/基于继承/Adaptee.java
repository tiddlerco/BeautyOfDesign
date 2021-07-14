package design.adapter.基于继承;

/**
 * 一组不兼容 ITarget 接口定义的接口
 * <p>
 * 如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都不相同，
 * 那我们推荐使用对象适配器，因为组合结构相对于继承更加灵活。
 *
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
