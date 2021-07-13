package design.strategy.improve.discount;

import design.strategy.entity.Order;

/**
 * 策略的定义
 *
 * @Author 喻可
 * @Date 2021/7/13 13:57
 */
public interface DiscountStrategy {
    double calDiscount(Order order);
}
