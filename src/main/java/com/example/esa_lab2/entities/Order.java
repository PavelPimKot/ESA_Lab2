package com.example.esa_lab2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Order.TABLE_NAME)
@ToString
@Getter
@Setter
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

    public void addElement(Element element) {
        if (elements == null) {
            elements = new ArrayList<>();
        }
        elements.add(element);
    }
}
