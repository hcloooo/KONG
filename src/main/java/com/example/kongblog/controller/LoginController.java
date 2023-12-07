package com.example.kongblog.controller;

import com.example.kongblog.model.User;
import com.example.kongblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class LoginController {


//    @Autowired
//    private UserService userService;
//    @GetMapping
//    public String loginPage() {
//        return "admin/login";
//    }
//
//    @GetMapping("/register")
//    public String registerPage() { return "admin/register";}
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpSession session,
//                        RedirectAttributes attributes) {
//        User user = userService.checkUser(username, password);
//        if (user != null) {
//            user.setPassword(null);
//            session.setAttribute("user",user);
//            return "admin/index";
//        } else {
//            attributes.addFlashAttribute("message", "用户名和密码错误");
//            return "redirect:/admin";
//        }
//    }
//
//    @GetMapping("/logout")
//    public String logout(HttpSession session) {
//        session.removeAttribute("user");
//        return "redirect:/admin";
//    }
//    @PostMapping("/registers")
//    @ResponseBody
//    public User register(String username, String email, String password){
//        User user = new User();
//        user.setPassword(password);
//        user.setEmail(email);
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUsername(username);
//        return userService.registerUser(user);
//    }
}
