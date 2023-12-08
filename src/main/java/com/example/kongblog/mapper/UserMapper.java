package com.example.kongblog.mapper;

import com.example.kongblog.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

// UserMapper.java
@Mapper
public interface UserMapper {
    void insertUser(User user);
    User getUserById(Long userId);
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(Long id);
    // other methods
}