package gic.itc.coffee_shop.Entity;

import java.util.List;

public class OrderDataList {
    private List<OrderData> orderList;

    public OrderDataList() {
    }

    public OrderDataList(List<OrderData> orderList) {
        this.orderList = orderList;
    }

    public List<OrderData> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderData> orderList) {
        this.orderList = orderList;
    }
}