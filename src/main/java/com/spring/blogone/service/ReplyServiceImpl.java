package com.spring.blogone.service;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;
import com.spring.blogone.entity.Reply;
import com.spring.blogone.repository.ReplyJPARepository;
import com.spring.blogone.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  ReplyServiceImpl implements ReplyService {

    ReplyRepository replyRepository;

    ReplyJPARepository replyJPARepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository){
        this.replyJPARepository = replyJPARepository;
    }
    @Override
    public List<Reply> findAllByBlogId(long blogId) {
        return replyJPARepository.findAllByBlogId(blogId);
    }

    @Override
    public Reply findByReplyId(long replyId) {
        return replyJPARepository.findById(replyId).get();
    }

    @Override
    public void deleteByReplyId(long replyId) {

        blog
        replyJPARepository.deleteById(replyId);
    }

    @Override
    public void save(Reply reply) {
        replyJPARepository.save(reply);
    }

    @Override
    public void update(Reply reply) {

        Reply updatedReply = replyJPARepository.findById(reply.getReplyId()).get();

        updatedReply.setReplyWriter(reply.getReplyWriter());
        updatedReply.setReplyContent(reply.getReplyContent());

        replyJPARepository.save(updatedReply);
    }

}
