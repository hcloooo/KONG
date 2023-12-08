package com.example.kongblog.controller.admin;

import com.example.kongblog.model.User;
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
        User user = userService.checkUser(username, password);
        if (user != null) {
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
        if(userService.getUserByUsername(username)==null){
            User user = new User();
            user.setPassword(password);
            user.setEmail(email);
            user.setCreatedAt(LocalDateTime.now());
            user.setUsername(username);
            if (!(userService.registerUser(user)==null)) {
                // Redirect to admin/index upon successful registration
                return "1";
            }
        }

        return "0";

    }
    @GetMapping("/index")
    public String Index(HttpSession session){
        if(session.getAttribute("user")!=null){
            return "admin/index";
        }else {
            return "redirect:/admin";
        }
    }

}
