package com.example.esa_lab2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class User extends EntityClass {

    private interface Columns {
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String MIDDLE_NAME = "middleName";
        String PASSWORD = "password";
        String LOGIN = "login";
        String PHONE = "phone";
    }

    public User() {

    }

    @Column(name = Columns.FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = Columns.LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = Columns.MIDDLE_NAME)
    private String middleName;

    @Column(name = Columns.PASSWORD, nullable = false)
    private String password;

    @Column(name = Columns.LOGIN, nullable = false)
    private String login;

    @Column(name = Columns.PHONE, nullable = false)
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return String.format("%s %s %s", getLastName(), getFirstName(), getMiddleName());
    }

    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
