package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.SectionRepository;
import com.example.esa_lab2.entities.Section;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "sectionRepository")
@Transactional
public class SectionRepositoryImpl extends AbstractRepository implements SectionRepository {
    @Override
    public List<Section> getSections() {
        return entityManager.createQuery("select section from Section section where section.isDeleted = false", Section.class).
                getResultList();
    }
}
