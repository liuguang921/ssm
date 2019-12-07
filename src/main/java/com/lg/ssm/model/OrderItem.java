package com.lg.ssm.model;

public class OrderItem {
    private Integer orderItemId;

    private Integer productId;

    private Integer quantity;

    private Integer oid;

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", oid=" + oid +
                '}';
    }

    public OrderItem(Integer orderItemId, Integer productId, Integer quantity, Integer oid) {
        this.orderItemId = orderItemId;
        this.productId = productId;
        this.quantity = quantity;
        this.oid = oid;
    }

    public OrderItem() {
        super();
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}