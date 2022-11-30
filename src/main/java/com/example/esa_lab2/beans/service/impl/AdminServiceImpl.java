package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.AdminRepositoryImpl;
import com.example.esa_lab2.beans.service.AdminService;
import com.example.esa_lab2.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

    public AdminServiceImpl(AdminRepositoryImpl adminRepository) {
        this.adminRepository = adminRepository;
    }

    private AdminRepositoryImpl adminRepository;

    @Override
    public List<Admin> findAdminByLoginAndPassword(String login, String password) {
        return adminRepository.findAdminByLoginAndPassword(login, password);
    }
}
