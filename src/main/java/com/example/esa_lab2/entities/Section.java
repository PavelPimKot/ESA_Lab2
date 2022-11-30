package com.example.esa_lab2.entities;

import com.example.esa_lab2.dto.SectionRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = Section.TABLE_NAME)
public class Section extends EntityClass {

    public final static String TABLE_NAME = "Section";

    private interface Columns {
        String NAME = "name";
        String DESCRIPTION = "description";
    }

    @Column(name = Columns.NAME, nullable = false)
    public String name;


    @Column(name = Columns.DESCRIPTION, nullable = false)
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
