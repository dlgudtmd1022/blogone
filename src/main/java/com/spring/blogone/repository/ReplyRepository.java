package com.spring.blogone.repository;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyRepository {

    List<ReplyFindByIdDTO> findAllByBlogId(long blogId);

    ReplyFindByIdDTO findById(long replyId);

    void deleteById(long replyId);

    void save(ReplyCreateRequestDTO replyCreateRequestDTO);

    void update(ReplyUpdateDTO replyUpdateDTO);

    void deleteByBlogId(long blogId);
}
