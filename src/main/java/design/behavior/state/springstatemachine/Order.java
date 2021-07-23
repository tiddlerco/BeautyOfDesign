package design.behavior.state.springstatemachine;

import design.behavior.state.springstatemachine.orderstate.OrderStatus;

/**
 * @Author 喻可
 * @Date 2021/7/23 14:00
 */
public class Order {

    private int id;
    //数据库可以直接保存enum类型的数据
    private OrderStatus status;

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "订单号：" + id + ", 订单状态：" + status;
    }

    public static void main(String[] args) {

        Order order = new Order();

        order.setStatus(OrderStatus.FINISH);

        System.out.println(order.getStatus());
    }

}