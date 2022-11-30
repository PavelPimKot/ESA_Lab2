package com.example.esa_lab2.beans.service;

import com.example.esa_lab2.entities.Product;

import java.util.List;

public interface ProductService {
    Product findProductById(Integer productId);

    List<Product> getProducts();
}
