package com.example.kongblog.service;

import com.example.kongblog.model.User;

import java.util.List;

// UserService.java
public interface UserService {
    User checkUser(String username,String password);
    User registerUser(User user);
    User getUserById(Long userId);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    // other methods
}