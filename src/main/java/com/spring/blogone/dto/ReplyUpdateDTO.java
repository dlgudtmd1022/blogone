package com.spring.blogone.dto;

import com.spring.blogone.entity.Reply;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyUpdateDTO {
    private long replyId;
    private String replyWriter;
    private String replyContent;

    public ReplyUpdateDTO(Reply reply){
        this.replyId = reply.getReplyId();
        this.replyWriter = reply.getReplyWriter();
        this.replyContent = reply.getReplyContent();
    }
}
