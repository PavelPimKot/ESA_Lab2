package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.EntityChangeLogRepositoryImpl;
import com.example.esa_lab2.beans.service.EntityChangeLogService;
import com.example.esa_lab2.entities.EntityChangeLog;
import org.springframework.stereotype.Service;

@Service(value = "entityChangeLogService")
public class EntityChangeLogServiceImpl implements EntityChangeLogService {
    private EntityChangeLogRepositoryImpl entityChangeLogRepository;

    public EntityChangeLogServiceImpl(EntityChangeLogRepositoryImpl entityChangeLogRepository) {
        this.entityChangeLogRepository = entityChangeLogRepository;
    }

    @Override
    public void save(EntityChangeLog entityChangeLog) {
        entityChangeLogRepository.save(entityChangeLog);
    }
}
