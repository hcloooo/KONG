package com.example.kongblog.mapper;

import com.example.kongblog.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// AdminMapper.java
@Mapper
public interface AdminMapper {
    Admin getAdminByUsername(String username);
    List<Admin> getAllAdmins();

    void insertAdmin(Admin admin);
    // other methods
}