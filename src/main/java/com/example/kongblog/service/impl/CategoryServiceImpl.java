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

    public List<Category> getAllCategories() {
        return categoryMapper.getAllCategories();
    }

    public void addCategory(Category category) {
        categoryMapper.addCategory(category);
    }

    public Category getCategoryById(Long id) {
        return categoryMapper.getCategoryById(id);
    }

    public void editCategory(Category category) {
        categoryMapper.editCategory(category);
    }

     public void deleteCategory(Long id) {
        categoryMapper.deleteCategory(id);
    }
}
