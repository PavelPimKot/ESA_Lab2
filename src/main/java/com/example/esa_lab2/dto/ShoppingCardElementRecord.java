package com.example.esa_lab2.dto;

public class ShoppingCardElementRecord {
    private String pictureUrl;
    private String name;
    private int cost;
    private Integer elementId;
    private Integer productId;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Integer getElementId() {
        return elementId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
