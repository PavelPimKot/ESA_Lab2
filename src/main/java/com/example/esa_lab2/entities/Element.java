package com.example.esa_lab2.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = Element.TABLE_NAME)
public class Element implements Serializable {

    public final static String TABLE_NAME = "Element";

    private interface Columns {
        String CODE = "code";
        String ORDER = "order_ID";
        String PRODUCT = "product_ID";
        String COUNT = "count";
        String IS_DELETED = "isDeleted";
    }

    public Element() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Columns.CODE)
    private Integer code;


    @ManyToOne
    @JoinColumn(name = Columns.ORDER, nullable = false)
    private Order order;


    @OneToOne
    @JoinColumn(name = Columns.PRODUCT, nullable = false)
    private Product product;


    @Column(name = Columns.COUNT, nullable = false)
    private int count;


    @Column(name = Columns.IS_DELETED)
    private boolean isDeleted = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order orderId) {
        this.order = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public String toString() {
        return "Element{" +
                super.toString() +
                "code='" + code + '\'' +
                ", order=" + order +
                ", product=" + product +
                ", count=" + count +
                '}';
    }
}
