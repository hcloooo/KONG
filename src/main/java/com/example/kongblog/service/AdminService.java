package com.example.kongblog.service;

import com.example.kongblog.model.Admin;
import com.example.kongblog.model.User;

import java.util.List;

// AdminService.java
public interface AdminService {
    Admin registerAdmin(Admin admin);
    Admin checkAdmin(String username, String password);
    Admin getAdminByUsername(String username);
    List<Admin> getAllAdmins();
}