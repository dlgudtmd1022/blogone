package com.spring.blogone.dto;

import com.spring.blogone.entity.Reply;
import lombok.*;

@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class ReplyCreateRequestDTO {

    private long blogId;
    private String replyWriter;
    private String replyContent;

    public ReplyCreateRequestDTO(Reply reply){
        this.blogId = reply.getBlogId();
        this.replyWriter = reply.getReplyWriter();
        this.replyContent = reply.getReplyContent();
    }
}
