package com.example.esa_lab2.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@MappedSuperclass
@ToString
@Getter
@Setter
public class EntityClass {

    private interface Columns {
        String ID = "ID";
        String IS_DELETED = "isDeleted";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Columns.ID)
    private Integer id;


    @Column(name = Columns.IS_DELETED, nullable = false)
    private boolean isDeleted = false;
}
