package com.example.kongblog.mapper;

import com.example.kongblog.model.Blog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogMapper {


    void insertBlog(Blog blog);

    Blog getBlogById(Long blogId);

    List<Blog> getAllBlogs();

    void updateBlog(Blog blog);

    void deleteBlog(Long blogId);

    // Other methods
}
