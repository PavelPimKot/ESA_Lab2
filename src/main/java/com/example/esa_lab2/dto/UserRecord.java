package com.example.esa_lab2.dto;

public class UserRecord extends EntityRecord {

    public UserRecord() {

    }

    public UserRecord(Integer id, String firstName, String lastName, String middleName, String password, String login, String phone) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setMiddleName(middleName);
        setPassword(password);
        setLogin(login);
        setPhone(phone);
    }

    private String firstName;

    private String lastName;

    private String middleName;

    private String password;

    private String login;

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

