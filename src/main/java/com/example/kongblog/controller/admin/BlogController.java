package com.example.kongblog.controller.admin;

import com.example.kongblog.model.Blog;
import com.example.kongblog.model.User;
import com.example.kongblog.model.vo.BlogVo;
import com.example.kongblog.service.BlogService;
import com.example.kongblog.service.CategoryService;
import com.example.kongblog.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    private final BlogService blogService;
    private final UserService userService;
    private final CategoryService categoryService;

    @Autowired
    public BlogController(BlogService blogService,UserService userService,CategoryService categoryService) {
        this.blogService = blogService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @GetMapping("/blogs")
    public String showBlogManagement(Model model, HttpSession session) {
        if((session.getAttribute("admin")==null)&&(session.getAttribute("user")==null)){
            return "redirect:/admin";
        }
        List<BlogVo> blogs = blogService.getAllBlogs();
        model.addAttribute("blogs", blogs);
        return "admin/blogs";
    }

    @GetMapping("/editBlog/{id}")
    public String showEditBlogForm(@PathVariable Long id, Model model, HttpSession session) {
        if((session.getAttribute("admin")==null)&&(session.getAttribute("user")==null)){
            return "redirect:/admin";
        }
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "admin/editBlog";
    }

    @PostMapping("/editBlog/{id}")
    public String editBlog(@PathVariable Long id, @ModelAttribute("blog") Blog blog, HttpSession session) {
        if((session.getAttribute("admin")==null)&&(session.getAttribute("user")==null)){
            return "redirect:/admin";
        }
        blog.setBlogId(id);
        blog.setCreatedAt(LocalDateTime.now());
        User user = (User) session.getAttribute("user");
        if(blog.getUserId()==null){
            if(user!=null){
                blog.setUserId(user.getUserId());
            }else {
                //管理员的userId默认为001
                blog.setUserId(001l);
            }
        }
        blogService.updateBlog(blog);
        return "redirect:/admin/blogs";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable Long id, HttpSession session) {
        if((session.getAttribute("admin")==null)&&(session.getAttribute("user")==null)){
            return "redirect:/admin";
        }
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }

    @GetMapping("/addBlog")
    public String showAddBlogForm(Model model, HttpSession session) {
        if((session.getAttribute("admin")==null)&&(session.getAttribute("user")==null)){
            return "redirect:/admin";
        }
        Blog blog = new Blog();
        if(session.getAttribute("user")!=null){
            blog.setUserId(blog.getUserId());
        }else {
            //管理员id
            blog.setUserId(001l);
        }
        model.addAttribute("blog", blog);
        return "admin/addBlog";
    }

    @PostMapping("/addBlog")
    public String addBlog(@ModelAttribute("blog") Blog blog, HttpSession session) {
        if((session.getAttribute("admin")==null)&&(session.getAttribute("user")==null)){
            return "redirect:/admin";
        }
        blog.setCreatedAt(LocalDateTime.now());
        User user = (User) session.getAttribute("user");
        if(blog.getUserId()==null){
            if(user!=null){
                blog.setUserId(user.getUserId());
            }else {
                //管理员的userId默认为001
                blog.setUserId(001l);
            }
        }
        blogService.createBlog(blog);
        return "redirect:/admin/blogs";
    }
}
