package com.example.esa_lab2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
@ToString
@Getter
@Setter
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

    public String getFullName() {
        return String.format("%s %s %s", getLastName(), getFirstName(), getMiddleName());
    }
}
