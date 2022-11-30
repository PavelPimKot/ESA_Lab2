package com.example.esa_lab2.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Admin{" +
                super.toString() +
                "position='" + position + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", salary=" + salary +
                '}';
    }
}
