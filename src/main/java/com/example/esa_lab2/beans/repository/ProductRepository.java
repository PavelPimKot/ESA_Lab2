package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Product;

import java.util.List;

public interface ProductRepository extends Repository {

    Product findProductById(Integer productId);

    List<Product> getProducts();
}
