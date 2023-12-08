package com.example.kongblog.mapper;

import com.example.kongblog.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> getAllCategories();

    void addCategory(Category category);

    Category getCategoryById(Long id);

    void editCategory(Category category);

    void deleteCategory(Long id);
}
