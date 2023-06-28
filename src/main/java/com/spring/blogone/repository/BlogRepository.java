package com.spring.blogone.repository;

import com.spring.blogone.entity.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogRepository {

    List<Blog> findAll();

    Blog findByID(long blogId);

    void save(Blog blog);

    void deleteById(long blogId);

    void update(Blog blog);

}
