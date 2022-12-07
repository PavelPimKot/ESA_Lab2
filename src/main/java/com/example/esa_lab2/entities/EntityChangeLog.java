package com.example.esa_lab2.entities;

import com.example.esa_lab2.enums.ChangeType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

import static com.example.esa_lab2.entities.EntityChangeLog.TABLE_NAME;

@Entity(name = TABLE_NAME)
@ToString
@Getter
@Setter
public class EntityChangeLog {

    public final static String TABLE_NAME = "ENTITY_CHANGE_LOG";

    private interface Columns {
        String ID = "ID";

        String ENTITY_ID = "ENTITY_ID";

        String CHANGE_DATE = "CHANGE_DATE";

        String CHANGE_TYPE = "CHANGE_TYPE";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Columns.ID)
    private Integer id;

    @Column(name = Columns.ENTITY_ID)
    private Integer entityId;

    @Column(name = Columns.CHANGE_DATE)
    private LocalDate changeDate;

    @Column(name = Columns.CHANGE_TYPE)
    @Enumerated(value = EnumType.STRING)
    private ChangeType changeType;
}
