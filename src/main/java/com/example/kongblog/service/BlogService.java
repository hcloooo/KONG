package com.example.kongblog.service;

import com.example.kongblog.model.Blog;
import com.example.kongblog.model.vo.BlogVo;

import java.util.List;

// BlogService.java
public interface BlogService {
    void createBlog(Blog blog);
    Blog getBlogById(Long blogId);
    List<BlogVo> getAllBlogs();
    void updateBlog(Blog blog);
    void deleteBlog(Long blogId);
    // other methods
}