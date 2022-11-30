package com.example.esa_lab2.dto;

import com.example.esa_lab2.entities.Category;

public class CategoryRecord extends EntityRecord {

    public CategoryRecord() {
    }

    public CategoryRecord(Integer id, String name, String description) {
        this.setName(name);
        this.setId(id);
        this.setDescription(description);
    }

    public CategoryRecord(Category category) {
        this(category.getId(), category.getName(), category.getDescription());
    }

    public String name;

    public String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
