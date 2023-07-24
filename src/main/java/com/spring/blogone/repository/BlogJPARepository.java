package com.spring.blogone.repository;

import com.spring.blogone.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository // bean container에서 관리하도록 해야 사용할 수 있음,
public interface BlogJPARepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllBy(Pageable pageable); // 페이징 정보를 받는 findAll 메서드 오버로딩
}