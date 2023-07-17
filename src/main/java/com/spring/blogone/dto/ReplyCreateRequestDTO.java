package com.spring.blogone.dto;

import com.spring.blogone.entity.Reply;
import lombok.*;

@Getter @Setter @ToString @Builder
@AllArgsConstructor @NoArgsConstructor
public class ReplyCreateRequestDTO {

    private long replyId;
    private String replyWriter;
    private String replyContent;

    public ReplyCreateRequestDTO(Reply reply){
        this.replyId = reply.getReplyId();
        this.replyWriter = reply.getReplyWriter();
        this.replyContent = reply.getReplyContent();
    }
}
