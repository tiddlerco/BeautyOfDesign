package design.behavior.chainresponsibility.way2;


import java.util.ArrayList;
import java.util.List;

/**
 * HandlerChain 类用集合而非链表来保存所有的处理器
 * 如果处理器链上的某个处理器能够处理这个请求，那就不会继续往下传递请求
 *
 * @Author 喻可
 * @Date 2021/7/19 16:34
 */
public class HandlerChain {

    private List<IHandler> handlers = new ArrayList<>();
    //之前迷惑这里的handler是怎么注入到spring容器的
    //参考FormItemConverterFactory里的set注入方式  2021/11/2
    public void addHandler(IHandler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            //把这里的判断去掉，就是职责链模式的另一种变体，
            // 请求会被所有的处理器都处理一遍，不存在中途终止的情况
            if (handled) {
                break;
            }
        }
    }
}

