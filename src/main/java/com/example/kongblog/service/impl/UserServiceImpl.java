package com.example.kongblog.service.impl;

import com.example.kongblog.mapper.UserMapper;
import com.example.kongblog.model.User;
import com.example.kongblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// UserServiceImpl.java
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required=true)
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        User user = getUserByUsername(username);
        if(user!=null&&user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public User registerUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }

}
