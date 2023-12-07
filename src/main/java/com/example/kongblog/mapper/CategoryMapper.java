package com.example.kongblog.mapper;

import com.example.kongblog.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// CategoryMapper.java
@Mapper
public interface CategoryMapper {
    void insertCategory(Category category);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    // other methods
}