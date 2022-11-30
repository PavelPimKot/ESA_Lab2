package com.example.esa_lab2.entities;


import jakarta.persistence.*;

@MappedSuperclass
public class EntityClass {

    private interface Columns {
        String ID = "ID";
        String IS_DELETED = "isDeleted";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Columns.ID)
    private Integer id;


    @Column(name = Columns.IS_DELETED, nullable = false)
    private boolean isDeleted = false;


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
