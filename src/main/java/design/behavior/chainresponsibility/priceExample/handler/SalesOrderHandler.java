package design.behavior.chainresponsibility.priceExample.handler;

import design.behavior.chainresponsibility.priceExample.OrderHandleContext;
import design.behavior.chainresponsibility.priceExample.OrderHandlerChain;
import design.behavior.chainresponsibility.priceExample.OrderHandlerWeightEnum;
import org.springframework.stereotype.Component;

/**
 * 促销活动
 * @author WeJan
 * @since 2020-02-11
 */
@Component
public class SalesOrderHandler extends AbstractHandler {
    @Override
    public void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        Double amount = context.getAmount();
        if (amount > 80) {
            context.setAmount(amount * 0.9);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    public int weight() {
        return OrderHandlerWeightEnum.SALES.getCode();
    }
}
