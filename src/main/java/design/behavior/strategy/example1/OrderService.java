package design.behavior.strategy.example1;

import design.behavior.strategy.example1.entity.Order;
import design.behavior.strategy.example1.entity.OrderType;

/**
 * 需要改进的地方：对代码进行重构，移除掉分支的判断逻辑
 *
 * @Author 喻可
 * @Date 2021/7/13 13:50
 */

public class OrderService {

    public double discount(Order order) {
        double discount = 0.0;
        OrderType type = order.getType();
        if (type.equals(OrderType.NORMAL)) { // 普通订单
            //...省略折扣计算算法代码
        } else if (type.equals(OrderType.GROUPON)) { // 团购订单
            //...省略折扣计算算法代码
        } else if (type.equals(OrderType.PROMOTION)) { // 促销订单
            //...省略折扣计算算法代码
        }
        return discount;
    }
}
