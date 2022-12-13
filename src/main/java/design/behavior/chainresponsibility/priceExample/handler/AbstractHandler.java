package design.behavior.chainresponsibility.priceExample.handler;


import design.behavior.chainresponsibility.priceExample.OrderHandleContext;
import design.behavior.chainresponsibility.priceExample.OrderHandlerChain;

/**
 * @author WeJan
 * @since 2020-02-11
 */
public abstract class AbstractHandler {

    public abstract void doHandle(OrderHandleContext context, OrderHandlerChain chain);

    /**
     * 订单处理器的权重
     */
    public abstract int weight();

}
