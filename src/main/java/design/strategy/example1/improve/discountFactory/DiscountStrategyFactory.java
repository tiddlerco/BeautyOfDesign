package design.strategy.example1.improve.discountFactory;

import design.strategy.example1.entity.OrderType;
import design.strategy.example1.improve.discount.DiscountStrategy;
import design.strategy.example1.improve.discount.discountimpl.GrouponDiscountStrategy;
import design.strategy.example1.improve.discount.discountimpl.NormalDiscountStrategy;
import design.strategy.example1.improve.discount.discountimpl.PromotionDiscountStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略的创建
 *
 * @Author 喻可
 * @Date 2021/7/13 14:06
 */
public class DiscountStrategyFactory {

    private static final Map<OrderType, DiscountStrategy> strategies = new HashMap<>();

    static {
        strategies.put(OrderType.NORMAL, new NormalDiscountStrategy());
        strategies.put(OrderType.GROUPON, new GrouponDiscountStrategy());
        strategies.put(OrderType.PROMOTION, new PromotionDiscountStrategy());
    }

    public static DiscountStrategy getDiscountStrategy(OrderType type) {
        return strategies.get(type);
    }
}
