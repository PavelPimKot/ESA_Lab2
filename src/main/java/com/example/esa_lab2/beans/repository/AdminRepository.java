package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Admin;

import java.util.List;

public interface AdminRepository extends Repository{
    List<Admin> findAdminByLoginAndPassword(String login, String password);
}
