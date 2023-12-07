package com.example.kongblog.service.impl;


import com.example.kongblog.mapper.BlogMapper;
import com.example.kongblog.mapper.CategoryMapper;
import com.example.kongblog.mapper.UserMapper;
import com.example.kongblog.model.Blog;
import com.example.kongblog.model.User;
import com.example.kongblog.model.vo.BlogVo;
import com.example.kongblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void createBlog(Blog blog) {
        blogMapper.insertBlog(blog);
    }

    @Override
    public Blog getBlogById(Long blogId) {
        return blogMapper.getBlogById(blogId);
    }

    @Override
    public List<BlogVo> getAllBlogs() {
        List<Blog> allBlogs = blogMapper.getAllBlogs();
        List<BlogVo> blogVos = new ArrayList<>();
        for (int i = 0; i < allBlogs.size(); i++) {
            BlogVo blogVo = new BlogVo();
            Blog blog = allBlogs.get(i);
            blogVo.setBlogId(blog.getBlogId());
            blogVo.setContent(blog.getContent());
            blogVo.setTitle(blog.getTitle());
            blogVo.setCreatedAt(blog.getCreatedAt());
            blogVo.setUser(userMapper.getUserById(blog.getUserId()));
            blogVo.setCategory(categoryMapper.getCategoryById(blog.getCategoryId()));
            blogVos.add(blogVo);
        }
        return blogVos;
    }

    @Override
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }

    @Override
    public void deleteBlog(Long blogId) {
        blogMapper.deleteBlog(blogId);
    }

    // Implement other methods as needed
}
