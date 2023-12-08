package com.example.kongblog.service;

import com.example.kongblog.model.Category;

import java.util.List;

public interface CategoryService {


     List<Category> getAllCategories();

     void addCategory(Category category);

     Category getCategoryById(Long id);

    void editCategory(Category category) ;

    void deleteCategory(Long id);
}
