package design.behavior.chainresponsibility.priceExample.handler;

import design.behavior.chainresponsibility.priceExample.OrderHandleContext;
import design.behavior.chainresponsibility.priceExample.OrderHandlerChain;
import design.behavior.chainresponsibility.priceExample.OrderHandlerWeightEnum;
import org.springframework.stereotype.Component;

/**
 * 优惠券
 *
 * @author WeJan
 * @since 2020-02-11
 */
@Component
public class CouponOrderHandler extends AbstractHandler {

    @Override
    public void doHandle(OrderHandleContext context, OrderHandlerChain chain) {
        if (context.getCouponNo() != null) {
            context.setAmount(context.getAmount() - 10);
        }
        // 调用下一个处理器进行处理
        chain.handle(context);
    }

    @Override
    public int weight() {
        return OrderHandlerWeightEnum.COUPON.getCode();
    }
}
