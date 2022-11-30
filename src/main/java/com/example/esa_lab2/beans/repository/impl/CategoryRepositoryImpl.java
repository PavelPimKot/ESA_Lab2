package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.CategoryRepository;
import com.example.esa_lab2.entities.Category;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "categoryRepository")
@Transactional
public class CategoryRepositoryImpl extends AbstractRepository implements CategoryRepository {
    @Override
    public List<Category> getCategories() {
        return entityManager.createQuery("select category from Category category where category.isDeleted = false", Category.class).
                getResultList();
    }
}
