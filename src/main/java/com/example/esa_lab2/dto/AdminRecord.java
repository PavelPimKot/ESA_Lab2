package com.example.esa_lab2.dto;

import com.example.esa_lab2.entities.Admin;

public class AdminRecord extends UserRecord {


    public AdminRecord() {

    }


    public AdminRecord(Integer id, String firstName, String lastName, String middleName, String password, String login, String phone, String position, String workExperience, int salary) {
        super(id, firstName, lastName, middleName, password, login, phone);
        setPosition(position);
        setWorkExperience(workExperience);
        setSalary(salary);
    }

    public AdminRecord(Admin admin) {
        this(
                admin.getId(),
                admin.getFirstName(),
                admin.getLastName(),
                admin.getMiddleName(),
                admin.getPassword(),
                admin.getLogin(),
                admin.getPhone(),
                admin.getPosition(),
                admin.getWorkExperience(),
                admin.getSalary()
        );
    }

    private String position;

    private String workExperience;

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