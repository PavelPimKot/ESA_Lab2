package com.example.esa_lab2.dto;

import com.example.esa_lab2.entities.Client;

import java.util.Date;

public class ClientRecord extends UserRecord {

    public ClientRecord() {
    }

    public ClientRecord(
            Integer id, String firstName, String lastName, String middleName, String password, String login,
            String phone, Date birthDay, String email, String address
    ) {
        super(id, firstName, lastName, middleName, password, login, phone);
        setBirthDay(birthDay);
        setEmail(email);
        setAddress(address);
    }


    public ClientRecord(Client client) {
        this(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getMiddleName(),
                client.getPassword(),
                client.getLogin(),
                client.getPhone(),
                client.getBirthDay(),
                client.getEmail(),
                client.getAddress()
        );
    }

    private Date birthDay;

    private String email;

    private String address;


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                super.toString() +
                "birthDay=" + birthDay +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
