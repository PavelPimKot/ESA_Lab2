package com.example.esa_lab2.entities;

import com.example.esa_lab2.dto.ProductRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Product.TABLE_NAME)
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categoryId) {
        this.category = categoryId;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section sectionId) {
        this.section = sectionId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Product{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", category=" + category +
                ", section=" + section +
                ", picture='" + picture + '\'' +
                '}';
    }
}
