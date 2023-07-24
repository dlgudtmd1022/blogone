package com.spring.blogone.repository;

import com.spring.blogone.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyJPARepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByBlogId(long blogId);
}
