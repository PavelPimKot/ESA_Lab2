package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.ElementRepository;
import com.example.esa_lab2.entities.Element;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service(value = "elementRepository")
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
