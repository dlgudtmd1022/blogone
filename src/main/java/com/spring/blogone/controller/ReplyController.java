package com.spring.blogone.controller;

import com.spring.blogone.dto.ReplyFindByBlogIdDTO;
import com.spring.blogone.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService){
        this.replyService = replyService;
    }

    @GetMapping("/{blogId}/all")
    public ResponseEntity<List<ReplyFindByBlogIdDTO>> findAllReplies(@PathVariable long blogId){

        List<ReplyFindByBlogIdDTO> replies = replyService.findAllByBlogId(blogId);

        return ResponseEntity.ok().body(replies);
    }

}
