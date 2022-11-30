package com.example.esa_lab2.dto;

public class ElementRecord extends EntityRecord {

    private String code;

    private long orderId;

    private long productId;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Element{" +
                super.toString() +
                "code='" + code + '\'' +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }
}
