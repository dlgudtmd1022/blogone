package com.spring.blogone.service;

import com.spring.blogone.entity.Blog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BlogService {

    Page<Blog> findAll(Long pageNum);

    Blog findById(long blogId);

    void deleteById(long blogId);

    void save (Blog blog);

    void update(Blog blog);
}
