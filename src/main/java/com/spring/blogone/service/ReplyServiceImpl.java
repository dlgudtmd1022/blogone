package com.spring.blogone.service;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;
import com.spring.blogone.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    ReplyRepository replyRepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }
    @Override
    public List<ReplyFindByIdDTO> findAllByBlogId(long blogId) {
        return replyRepository.findAllByBlogId(blogId);
    }

    @Override
    public ReplyFindByIdDTO findByReplyId(long replyId) {
        return replyRepository.findByReplyId(replyId);
    }

    @Override
    public void deleteByReplyId(long replyId) {
        replyRepository.deleteByReplyId(replyId);
    }

    @Override
    public void save(ReplyCreateRequestDTO replyCreateRequestDTO) {
        replyRepository.save(replyCreateRequestDTO);
    }

    @Override
    public void update(ReplyUpdateDTO replyUpdateDTO) {
        replyRepository.update(replyUpdateDTO);
    }

}
