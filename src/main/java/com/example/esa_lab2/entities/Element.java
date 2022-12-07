package com.example.esa_lab2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = Element.TABLE_NAME)
@ToString
@Getter
@Setter
public class Element implements Serializable {

    public final static String TABLE_NAME = "Element";

    private interface Columns {
        String CODE = "code";
        String ORDER = "order_ID";
        String PRODUCT = "product_ID";
        String COUNT = "count";
        String IS_DELETED = "isDeleted";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Columns.CODE)
    private Integer code;


    @JsonIgnore
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
}
