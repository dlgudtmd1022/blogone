package com.spring.blogone.repository;

import com.spring.blogone.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface BlogJPARepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);
}