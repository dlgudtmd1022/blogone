package com.spring.blogone.service;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;
import com.spring.blogone.entity.Reply;


import java.util.List;

public interface ReplyService {

    List<Reply> findAllByBlogId(long blogId);

    Reply findByReplyId(long replyId);

    void deleteByReplyId(long replyId);

    void save(Reply reply);

    void update(Reply reply);
}
