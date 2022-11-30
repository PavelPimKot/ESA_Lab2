package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.CategoryRepositoryImpl;
import com.example.esa_lab2.beans.service.CategoryService;
import com.example.esa_lab2.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService {
    public CategoryServiceImpl(CategoryRepositoryImpl categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private CategoryRepositoryImpl categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.getCategories();
    }
}
