package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.ProductRepository;
import com.example.esa_lab2.entities.Product;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "productRepository")
@Transactional
public class ProductRepositoryImpl extends AbstractRepository implements ProductRepository {
    @Override
    public Product findProductById(Integer productId) {
        return entityManager.find(Product.class, productId);
    }

    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery(" select product from Product product where  product.count > 0 and product.isDeleted = false", Product.class).getResultList();
    }
}
