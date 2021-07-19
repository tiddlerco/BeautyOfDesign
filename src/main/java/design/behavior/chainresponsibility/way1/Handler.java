package design.behavior.chainresponsibility.way1;

/**
 * 责任链加模板模式
 * 实现方式1
 *
 * @Author 喻可
 * @Date 2021/7/19 16:41
 */

public abstract class Handler {

    //successor 继承者
    protected Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {

        //模板模式的使用
        boolean handled = doHandle();

        //去掉这个判断!handled，就是职责链模式的另一种变体
        // 请求会被所有的处理器都处理一遍，不存在中途终止的情况
        if (successor != null && !handled) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();
}





