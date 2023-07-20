package com.spring.blogone.service;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;


import java.util.List;

public interface ReplyService {

    List<ReplyFindByIdDTO> findAllByBlogId(long blogId);

    ReplyFindByIdDTO findByReplyId(long replyId);

    void deleteByReplyId(long replyId);

    void save(ReplyCreateRequestDTO replyCreateRequestDTO);

    void update(ReplyUpdateDTO replyUpdateDTO);
}
