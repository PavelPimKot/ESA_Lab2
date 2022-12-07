package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.annotations.SaveEntityLoggable;
import com.example.esa_lab2.beans.repository.Repository;
import com.example.esa_lab2.entities.EntityClass;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractRepository implements Repository {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    @Transactional
    @SaveEntityLoggable
    public EntityClass save(EntityClass entityClass) {
        if (entityClass.getId() != null) {
            entityManager.merge(entityClass);
            return entityClass;
        }
        entityManager.persist(entityClass);
        return entityClass;
    }
}
