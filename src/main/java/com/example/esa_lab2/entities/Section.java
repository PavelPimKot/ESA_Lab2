package com.example.esa_lab2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Section.TABLE_NAME)
@ToString
@Getter
@Setter
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
}
