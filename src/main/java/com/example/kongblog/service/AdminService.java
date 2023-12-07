package com.example.kongblog.service;

import com.example.kongblog.model.Admin;

import java.util.List;

// AdminService.java
public interface AdminService {
    Admin getAdminByUsername(String username);
    List<Admin> getAllAdmins();
}