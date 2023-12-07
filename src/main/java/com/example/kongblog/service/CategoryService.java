package com.example.kongblog.service;

import com.example.kongblog.model.Category;

import java.util.List;

// CategoryService.java
public interface CategoryService {
    void createCategory(Category category);
    Category getCategoryById(Long categoryId);
    List<Category> getAllCategories();
    // other methods
}
