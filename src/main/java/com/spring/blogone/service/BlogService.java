package com.spring.blogone.service;

import com.spring.blogone.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();

    Blog findById(long blogId);

    void deleteById(long blogId);

    void save (Blog blog);

    void update(Blog blog);
}
