package com.example.kongblog.controller.admin;

import com.example.kongblog.model.Blog;
import com.example.kongblog.model.User;
import com.example.kongblog.model.vo.BlogVo;
import com.example.kongblog.service.BlogService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public String showBlogManagement(Model model, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/admin";
        }
        List<BlogVo> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "admin/blogs";
    }

    @GetMapping("/editBlog/{id}")
    public String showEditBlogForm(@PathVariable Long id, Model model, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/admin";
        }
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "admin/editBlog";
    }

    @PostMapping("/editBlog/{id}")
    public String editBlog(@PathVariable Long id, @ModelAttribute("blog") Blog blog, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/admin";
        }
        blog.setBlogId(id);
        blog.setCreatedAt(LocalDateTime.now());
        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getUserId());
        blogService.updateBlog(blog);
        return "redirect:/admin/blogs";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable Long id, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/admin";
        }
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }

    @GetMapping("/addBlog")
    public String showAddBlogForm(Model model, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/admin";
        }
        model.addAttribute("blog", new Blog());
        return "admin/addBlog";
    }

    @PostMapping("/addBlog")
    public String addBlog(@ModelAttribute("blog") Blog blog, HttpSession session) {
        if(session.getAttribute("user")==null){
            return "redirect:/admin";
        }
        blog.setCreatedAt(LocalDateTime.now());
        User user = (User) session.getAttribute("user");
        blog.setUserId(user.getUserId());
        blogService.createBlog(blog);
        return "redirect:/admin/blogs";
    }
}
