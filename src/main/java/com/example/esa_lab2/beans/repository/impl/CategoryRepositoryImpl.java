package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.CategoryRepository;
import com.example.esa_lab2.entities.Category;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "categoryRepository")
@Transactional
public class CategoryRepositoryImpl extends AbstractRepository implements CategoryRepository {
    @Override
    public List<Category> getCategories() {
        return entityManager.createQuery("select category from Category category where category.isDeleted = false", Category.class).
                getResultList();
    }
}
