package com.example.esa_lab2.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = Client.TABLE_NAME)
@ToString
@Getter
@Setter
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
}
