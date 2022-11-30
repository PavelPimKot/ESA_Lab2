package com.example.esa_lab2.entities;


import com.example.esa_lab2.dto.ClientRecord;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = Client.TABLE_NAME)
public class Client extends User {

    public final static String TABLE_NAME = "Client";

    private interface Columns {
        String BIRTH_DAY = "birthDay";
        String EMAIL = "email";
        String ADDRESS = "address";
    }

    public Client() {

    }

    @Column(name = Columns.BIRTH_DAY, nullable = false)
    private Date birthDay;


    @Column(name = Columns.EMAIL, nullable = false)
    private String email;


    @Column(name = Columns.ADDRESS, nullable = false)
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
