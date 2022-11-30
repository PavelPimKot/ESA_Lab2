package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Element;

public interface ElementRepository {
    void save(Element element);

    void persist(Element element);
}
