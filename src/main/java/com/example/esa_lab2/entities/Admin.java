package com.example.esa_lab2.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@ToString
@Getter
@Setter
public class Admin extends User {

    public final static String TABLE_NAME = "Admins";

    private interface Columns {
        String POSITION = "position";
        String WORK_EXPERIENCE = "workExperience";
        String SALARY = "salary";
    }

    @Column(name = Columns.POSITION, nullable = false)
    private String position;


    @Column(name = Columns.WORK_EXPERIENCE, nullable = false)
    private String workExperience;


    @Column(name = Columns.SALARY, nullable = false)
    private int salary;
}
