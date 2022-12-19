package com.example.esa_lab2.jms;

import com.example.esa_lab2.beans.service.impl.EmailSenderServiceImpl;
import com.example.esa_lab2.entities.EntityChangeLog;
import com.example.esa_lab2.jms.dto.EntityChangeRecord;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmailNotificationReceiver {
    private EmailSenderServiceImpl emailSenderService;

    public EmailNotificationReceiver(EmailSenderServiceImpl emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @JmsListener(destination = "entityChange")
    public void receiveMessage(EntityChangeRecord entityChangeRecord) {
        EntityChangeLog entityChangeLog = new EntityChangeLog();
        entityChangeLog.setEntityId(entityChangeRecord.getEntityId());
        entityChangeLog.setChangeDate(LocalDate.now());
        entityChangeLog.setChangeType(entityChangeRecord.getChangeType());
        emailSenderService.sendSimpleEmail("irauraltseva@gmail.com", "entityChange", entityChangeLog.toString());
    }
}
