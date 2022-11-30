package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.ElementRepositoryImpl;
import com.example.esa_lab2.beans.service.ElementService;
import com.example.esa_lab2.entities.Element;
import org.springframework.stereotype.Service;

@Service(value = "elementService")
public class ElementServiceImpl implements ElementService {
    public ElementServiceImpl(ElementRepositoryImpl elementRepository) {
        this.elementRepository = elementRepository;
    }

    private ElementRepositoryImpl elementRepository;

    @Override
    public void save(Element element) {
        elementRepository.save(element);
    }

    @Override
    public void persist(Element element) {
        elementRepository.persist(element);
    }
}
