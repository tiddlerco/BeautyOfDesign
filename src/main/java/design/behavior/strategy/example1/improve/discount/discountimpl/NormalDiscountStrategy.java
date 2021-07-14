package design.behavior.strategy.example1.improve.discount.discountimpl;

import design.behavior.strategy.example1.entity.Order;
import design.behavior.strategy.example1.improve.discount.DiscountStrategy;

/**
 * @Author 喻可
 * @Date 2021/7/13 14:01
 */
public class NormalDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
