package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Category;

import java.util.List;

public interface CategoryRepository extends Repository {
    public static final String JNDI_NAME = "CategoryRepository";
    List<Category> getCategories();
}
