package com.example.kongblog.service.impl;

import com.example.kongblog.mapper.AdminMapper;
import com.example.kongblog.model.Admin;
import com.example.kongblog.model.User;
import com.example.kongblog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// AdminServiceImpl.java
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin registerAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
        return admin;
    }

    @Override
    public Admin checkAdmin(String username, String password) {
        Admin admin = getAdminByUsername(username);
        if(admin!=null&&admin.getPassword().equals(password)){
            return admin;
        }
        return null;
    }


    @Override
    public Admin getAdminByUsername(String username) {
        return adminMapper.getAdminByUsername(username);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.getAllAdmins();
    }

    // Implement other methods as needed
}
