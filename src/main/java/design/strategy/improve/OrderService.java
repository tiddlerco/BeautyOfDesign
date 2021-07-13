package design.strategy.improve;

import design.strategy.entity.Order;
import design.strategy.entity.OrderType;
import design.strategy.improve.discount.DiscountStrategy;
import design.strategy.improve.discountFactory.DiscountStrategyFactory;

/**
 * 策略的使用
 *
 * @Author 喻可
 * @Date 2021/7/13 14:08
 */
public class OrderService {
    public double discount(Order order) {
        OrderType type = order.getType();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return discountStrategy.calDiscount(order);
    }
}
