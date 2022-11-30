package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.SectionRepositoryImpl;
import com.example.esa_lab2.beans.service.SectionService;
import com.example.esa_lab2.entities.Section;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "sectionService")
public class SectionServiceImpl implements SectionService {
    public SectionServiceImpl(SectionRepositoryImpl sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    private SectionRepositoryImpl sectionRepository;

    @Override
    public List<Section> getSections() {
        return sectionRepository.getSections();
    }
}
