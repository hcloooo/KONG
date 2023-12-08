package com.example.kongblog.controller.admin;

import com.example.kongblog.model.User;
import com.example.kongblog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUserManagement(Model model, HttpSession session) {
        if(session.getAttribute("admin")==null){
            return "redirect:/admin";
        }
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("/editUser/{id}")
    public String showEditUserForm(@PathVariable Long id, Model model, HttpSession session) {
        if(session.getAttribute("admin")==null){
            return "redirect:/admin";
        }
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @PostMapping("/editUser/{id}")
    public String editUser(@PathVariable Long id, @ModelAttribute("user") User user, HttpSession session) {
        if(session.getAttribute("admin")==null){
            return "redirect:/admin";
        }
        user.setUserId(id);
        userService.updateUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, HttpSession session) {
        if(session.getAttribute("admin")==null){
            return "redirect:/admin";
        }
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/addUser")
    public String showAddUserForm(Model model, HttpSession session) {
        if(session.getAttribute("admin")==null){
            return "redirect:/admin";
        }
        model.addAttribute("user", new User());
        return "admin/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user, HttpSession session) {
        if(session.getAttribute("admin")==null){
            return "redirect:/admin";
        }
        if(userService.getUserByUsername(user.getUsername())==null){
            userService.registerUser(user);
        }else {
            System.out.println("用户名以重复，重新注册");
            return "admin/addUser";
        }
        return "redirect:/admin/users";
    }
}
