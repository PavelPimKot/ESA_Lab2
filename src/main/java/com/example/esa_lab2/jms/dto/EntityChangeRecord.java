package com.example.esa_lab2.jms.dto;

import com.example.esa_lab2.enums.ChangeType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class EntityChangeRecord {
    private Integer entityId;
    private ChangeType changeType;
}
