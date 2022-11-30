package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.Repository;
import com.example.esa_lab2.entities.EntityClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public abstract class AbstractRepository implements Repository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    public void save(EntityClass entityClass) {
        if (entityClass.getId() != null) {
            entityManager.merge(entityClass);
            return;
        }
        entityManager.persist(entityClass);
    }
}
