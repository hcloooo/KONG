package com.example.kongblog.controller.admin;

import com.example.kongblog.model.Category;
import com.example.kongblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String showCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "admin/categories";
    }

    @GetMapping("/addCategory")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "admin/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/editCategory/{id}")
    public String showEditCategoryForm(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "admin/editCategory";
    }

    @PostMapping("/editCategory")
    public String editCategory(@ModelAttribute Category category) {
        categoryService.editCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/deleteCategory/{id}")
    public String showDeleteCategoryForm(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if(category!=null){
            categoryService.deleteCategory(category.getCategoryId());
        }else {
            System.out.println("删除失败");
        }
        return "redirect:/admin/categories";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@ModelAttribute Category category) {
        categoryService.deleteCategory(category.getCategoryId());
        return "redirect:/admin/categories";
    }
}
