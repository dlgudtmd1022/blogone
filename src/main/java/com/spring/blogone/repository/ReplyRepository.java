package com.spring.blogone.repository;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByBlogIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;
import com.spring.blogone.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyRepository {

    List<ReplyFindByBlogIdDTO> findAllByBlogId(long blogId);

    ReplyFindByBlogIdDTO findByReplyId(long replyId);

    void deleteByReplyId(long replyId);

    void save(ReplyCreateRequestDTO replyCreateRequestDTO);

    void update(ReplyUpdateDTO replyUpdateDTO);
}
