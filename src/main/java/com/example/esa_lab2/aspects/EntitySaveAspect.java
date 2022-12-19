package com.example.esa_lab2.aspects;

import com.example.esa_lab2.entities.EntityClass;
import com.example.esa_lab2.enums.ChangeType;
import com.example.esa_lab2.jms.dto.EntityChangeRecord;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Topic;
import java.util.Arrays;

@Aspect
@Component
public class EntitySaveAspect {

    private JmsTemplate jmsTemplate;

    private Topic topic;

    @Autowired
    public EntitySaveAspect(JmsTemplate jmsTemplate) throws JMSException {
        this.jmsTemplate = jmsTemplate;
        this.topic = jmsTemplate.getConnectionFactory().createConnection().createSession().createTopic("entityChange");
    }

    @Around("@annotation(com.example.esa_lab2.annotations.SaveEntityLoggable)")
    private Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        EntityClass savingEntity = (EntityClass) Arrays.stream(proceedingJoinPoint.getArgs()).findFirst().get();
        EntityChangeRecord record = new EntityChangeRecord();
        if (savingEntity.getId() == null) {
            record.setChangeType(ChangeType.INSERT);
        } else {
            record.setChangeType(ChangeType.UPDATE);
        }
        EntityClass result = (EntityClass) proceedingJoinPoint.proceed();
        record.setEntityId(result.getId());
        jmsTemplate.convertAndSend(topic, record);
        return result;
    }
}
