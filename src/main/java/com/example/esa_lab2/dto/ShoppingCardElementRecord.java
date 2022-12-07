package com.example.esa_lab2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ShoppingCardElementRecord {
    private String pictureUrl;
    private String name;
    private int cost;
    private Integer elementId;
    private Integer productId;
}
