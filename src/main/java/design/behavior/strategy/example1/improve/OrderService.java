package design.behavior.strategy.example1.improve;

import design.behavior.strategy.example1.entity.Order;
import design.behavior.strategy.example1.entity.OrderType;
import design.behavior.strategy.example1.improve.discount.DiscountStrategy;
import design.behavior.strategy.example1.improve.discountFactory.DiscountStrategyFactory;

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
