package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.ProductRepositoryImpl;
import com.example.esa_lab2.beans.service.ProductService;
import com.example.esa_lab2.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
    public ProductServiceImpl(ProductRepositoryImpl productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepositoryImpl productRepository;

    @Override
    public Product findProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }
}
