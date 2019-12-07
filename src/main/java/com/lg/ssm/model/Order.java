package com.lg.ssm.model;

public class Order {
    private Integer orderId;

    private String orderNo;

    public Order(Integer orderId, String orderNo) {
        this.orderId = orderId;
        this.orderNo = orderNo;
    }

    public Order() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}