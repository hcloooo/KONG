package com.example.kongblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.kongblog.mapper")
public class KongBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(KongBlogApplication.class, args);
    }


}
