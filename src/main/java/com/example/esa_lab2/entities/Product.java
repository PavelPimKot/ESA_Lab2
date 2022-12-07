package com.example.esa_lab2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = Product.TABLE_NAME)
@ToString
@Getter
@Setter
public class Product extends EntityClass {

    public final static String TABLE_NAME = "Product";

    private interface Columns {
        String NAME = "name";
        String DESCRIPTION = "description";
        String PRICE = "price";
        String COUNT = "count";
        String PICTURE = "picture";
    }

    @Column(name = Columns.NAME, nullable = false)
    private String name;


    @Column(name = Columns.DESCRIPTION, nullable = false)
    private String description;


    @Column(name = Columns.PRICE, nullable = false)
    private int price;


    @Column(name = Columns.COUNT, nullable = false)
    private int count;


    @ManyToOne
    private Category category;

    @ManyToOne
    private Section section;


    @Column(name = Columns.PICTURE, nullable = false)
    private String picture;
}
