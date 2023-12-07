package com.example.kongblog.controller;

import com.example.kongblog.service.AdminService;
import com.example.kongblog.service.BlogService;
import com.example.kongblog.service.CategoryService;
import com.example.kongblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService; // Assuming you have a UserService

    @Autowired
    private BlogService blogService; // Assuming you have a BlogService

    @Autowired
    private CategoryService categoryService; // Assuming you have a CategoryService

    @Autowired
    private AdminService adminService; // Assuming you have an AdminService

    @GetMapping
    public String index(Model model) {
        // Add data to the model that you want to pass to the Thymeleaf template
        model.addAttribute("currentUrl", "/");
        model.addAttribute("latestBlogs", blogService.getAllBlogs()); // Implement getLatestBlogs() in BlogService
        model.addAttribute("categories", categoryService.getAllCategories()); // Implement getAllCategories() in CategoryService
        model.addAttribute("users", userService.getAllUsers()); // Implement getAllUsers() in UserService
        model.addAttribute("admins", adminService.getAllAdmins()); // Implement getAllAdmins() in AdminService

        // Return the name of the Thymeleaf template without the extension
        return "index";
    }
}
