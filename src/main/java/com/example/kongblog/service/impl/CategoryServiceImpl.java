package com.example.kongblog.service.impl;


import com.example.kongblog.mapper.CategoryMapper;
import com.example.kongblog.model.Category;
import com.example.kongblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void createCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryMapper.getCategoryById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    // Implement other methods as needed
}
