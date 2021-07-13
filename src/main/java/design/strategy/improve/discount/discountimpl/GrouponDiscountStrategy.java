package design.strategy.improve.discount.discountimpl;

import design.strategy.entity.Order;
import design.strategy.improve.discount.DiscountStrategy;

/**
 * @Author 喻可
 * @Date 2021/7/13 14:03
 */
public class GrouponDiscountStrategy implements DiscountStrategy {
    @Override
    public double calDiscount(Order order) {
        return 0;
    }
}
