package com.example.esa_lab2.dto;

import com.example.esa_lab2.entities.Product;

public class ProductRecord extends EntityRecord {

    public ProductRecord() {
    }

    public ProductRecord(Product product) {
        setName(product.getName());
        setCount(product.getCount());
        setCategoryId(product.getCategory().getId().intValue());
        setPrice(product.getPrice());
        setDescription(product.getDescription());
        setPicture(product.getPicture());
        setId(product.getId());
        setSectionId(product.getSection().getId().intValue());
    }

    private String name;

    private String description;

    private int price;

    private int count;

    private long categoryId;

    private long sectionId;

    private String picture;

    private long totalPrice;

    private long totalCount;


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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", categoryId=" + categoryId +
                ", sectionId=" + sectionId +
                ", picture='" + picture + '\'' +
                '}';
    }
}

