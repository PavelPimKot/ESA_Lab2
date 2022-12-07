package com.example.esa_lab2.jms;

import com.example.esa_lab2.beans.service.impl.EntityChangeLogServiceImpl;
import com.example.esa_lab2.entities.EntityChangeLog;
import com.example.esa_lab2.jms.dto.EntityChangeRecord;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EntityChangeReceiver {
    private EntityChangeLogServiceImpl entityChangeLogService;

    public EntityChangeReceiver(EntityChangeLogServiceImpl entityChangeLogService) {
        this.entityChangeLogService = entityChangeLogService;
    }

    @JmsListener(destination = "entityChange", containerFactory = "myFactory")
    public void receiveMessage(EntityChangeRecord entityChangeRecord) {
        EntityChangeLog entityChangeLog = new EntityChangeLog();
        entityChangeLog.setEntityId(entityChangeRecord.getEntityId());
        entityChangeLog.setChangeDate(LocalDate.now());
        entityChangeLog.setChangeType(entityChangeRecord.getChangeType());
        entityChangeLogService.save(entityChangeLog);
    }
}
