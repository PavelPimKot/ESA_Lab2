package com.example.esa_lab2.dto;

public class EntityRecord {

    private boolean isDeleted = false;

    private Integer id;

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EntityClass{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                '}';
    }

}