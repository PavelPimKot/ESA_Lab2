package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.EntityChangeLog;

public interface EntityChangeLogRepository {
    void save(EntityChangeLog entityChangeLog);
}
