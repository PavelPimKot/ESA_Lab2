package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.EntityChangeLogRepository;
import com.example.esa_lab2.entities.EntityChangeLog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository(value = "entityChangeLogRepository")
@Transactional
public class EntityChangeLogRepositoryImpl implements EntityChangeLogRepository {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(EntityChangeLog entityChangeLog) {
        if (entityChangeLog.getId() != null) {
            entityManager.merge(entityChangeLog);
        }
        entityManager.persist(entityChangeLog);
    }
}
