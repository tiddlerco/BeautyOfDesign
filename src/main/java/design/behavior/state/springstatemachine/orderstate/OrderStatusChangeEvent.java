package design.behavior.state.springstatemachine.orderstate;

/**
 * 订单状态改变事件
 *
 * @Author 喻可
 * @Date 2021/7/23 14:01
 */
public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED;
}