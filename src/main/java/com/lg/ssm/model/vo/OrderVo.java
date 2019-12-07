package com.lg.ssm.model.vo;

import com.lg.ssm.model.Order;
import com.lg.ssm.model.OrderItem;

import java.util.List;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-22 11:37
 */
public class OrderVo extends Order {
    private List<OrderItem> orderItem;

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
}
