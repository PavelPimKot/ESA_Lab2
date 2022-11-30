package com.example.esa_lab2.dto;

import com.example.esa_lab2.entities.Section;

public class SectionRecord extends EntityRecord {

    public SectionRecord() {
    }

    public SectionRecord(Section section) {
        setName(section.getName());
        setDescription(section.getDescription());
        setId(section.getId());
    }


    public String name;

    public String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Section{" +
                super.toString() +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}