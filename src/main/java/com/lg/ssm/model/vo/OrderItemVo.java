package com.lg.ssm.model.vo;

import com.lg.ssm.model.Order;
import com.lg.ssm.model.OrderItem;

/**
 * @author 废废
 * @site
 * @company xxx公司
 * @create 2019-11-22 11:42
 */
public class OrderItemVo extends OrderItem {
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
