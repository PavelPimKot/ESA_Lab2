package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.ElementRepository;
import com.example.esa_lab2.entities.Element;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository(value = "elementRepository")
@Transactional
public class ElementRepositoryImpl implements ElementRepository {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void save(Element element) {
        entityManager.merge(element);
    }

    @Override
    public void persist(Element element) {
        entityManager.persist(element);
    }
}
