package com.example.esa_lab2.beans.service;

import com.example.esa_lab2.entities.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAdminByLoginAndPassword(String login, String password);
}
