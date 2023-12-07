package com.example.kongblog.model;

import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

// Admin.java
public class Admin {
    private Long adminId;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    // getters and setters

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}