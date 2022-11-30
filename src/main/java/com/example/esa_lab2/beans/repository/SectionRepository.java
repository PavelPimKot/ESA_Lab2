package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Section;

import java.util.List;

public interface SectionRepository extends Repository{
    List<Section> getSections();
}
