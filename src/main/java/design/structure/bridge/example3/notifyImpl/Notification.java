package design.structure.bridge.example3.notifyImpl;


/**
 * 针对 Notification 的代码，我们将不同渠道的发送逻辑剥离出来，形成独立的消息发送类（MsgSender 相关类）
 * 其中，Notification 类相当于抽象，MsgSender 类相当于实现，两者可以独立开发，通过组合关系（也就是桥梁）任意组合在一起。
 * 所谓任意组合的意思就是，不同紧急程度的消息和发送渠道之间的对应关系，
 * 不是在代码中固定写死的，我们可以动态地去指定（比如，通过读取配置来获取对应关系）
 * <p>
 * 由一对一经过组装变为 多对多关系
 *一个类存在两个（或多个）独立变化的维度，我们通过组合的方式，让这两个（或多个）维度可以独立进行扩展
 * 桥接组合的实现几乎不会在运行时更改，而策略模式的算法很有可能在运行时替换
 * @Author 喻可
 * @Date 2021/7/13 9:58
 */
public abstract class Notification {

    public abstract void notify(String message);

}


