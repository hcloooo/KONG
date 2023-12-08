package com.example.kongblog.controller.admin;

import com.example.kongblog.model.Admin;
import com.example.kongblog.model.User;
import com.example.kongblog.service.AdminService;
import com.example.kongblog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @GetMapping("/register")
    public String registerPage() { return "admin/register";}
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        Admin admin = adminService.checkAdmin(username, password);
        User user = userService.checkUser(username, password);
        if (admin != null) {
            admin.setPassword(null);
            session.setAttribute("admin",admin);
            return "1";
        }else if(user!=null){
            user.setPassword(null);
            session.setAttribute("user",user);
            return "1";
        } else {
            return "0";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
    @PostMapping("/registers")
    @ResponseBody
    public String register(String username, String password, String email){
        if(adminService.getAdminByUsername(username)==null){
            Admin admin = new Admin();
            admin.setPassword(password);
            admin.setCreatedAt(LocalDateTime.now());
            admin.setUsername(username);
            if (!(adminService.registerAdmin(admin)==null)) {
                // Redirect to admin/index upon successful registration
                return "1";
            }
        }

        return "0";

    }
    @GetMapping("/index")
    public String Index(HttpSession session){
        if((session.getAttribute("admin")!=null)||(session.getAttribute("user")!=null)){
            return "admin/index";
        }else {
            return "redirect:/admin";
        }
    }

}
