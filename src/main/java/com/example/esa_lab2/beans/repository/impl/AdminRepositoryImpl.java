package com.example.esa_lab2.beans.repository.impl;

import com.example.esa_lab2.beans.repository.AdminRepository;
import com.example.esa_lab2.entities.Admin;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository(value = "adminRepository")
@Transactional
public class AdminRepositoryImpl extends AbstractRepository implements AdminRepository {
    @Override
    public List<Admin> findAdminByLoginAndPassword(String login, String password) {
        return entityManager.createQuery(
                "select admin from Admin admin where admin.isDeleted = false and admin.login = :login and admin.password = :password ",
                Admin.class).setParameter("login", login).setParameter("password", password).getResultList();
    }
}
