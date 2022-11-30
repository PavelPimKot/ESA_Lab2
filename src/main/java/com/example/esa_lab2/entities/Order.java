package com.example.esa_lab2.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Order.TABLE_NAME)
public class Order extends EntityClass {

    public final static String TABLE_NAME = "Orders";

    private interface Columns {
        String CLIENT = "client_ID";
        String STATUS = "status";
        String COST = "cost";
        String ORDER_DATE = "orderDate";
        String DELIVERY_DATE = "deliveryDate";
    }

    public Order() {

    }

    @ManyToOne
    @JoinColumn(name = Columns.CLIENT)
    private Client client;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Element> elements;


    @Column(name = Columns.STATUS, nullable = false)
    private String status;


    @Column(name = Columns.COST, nullable = false)
    private int cost;

    @Column(name = Columns.ORDER_DATE, nullable = false)
    private Date orderDate;

    @Column(name = Columns.DELIVERY_DATE, nullable = false)
    private Date deliveryDate;

    public Client getClient() {
        return client;
    }

    public void setClient(Client user) {
        this.client = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void addElement(Element element) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        elements.add(element);
    }

    public List<Element> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "Order{" +
                super.toString() +
                "client=" + client +
                ", status='" + status + '\'' +
                ", cost=" + cost +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
