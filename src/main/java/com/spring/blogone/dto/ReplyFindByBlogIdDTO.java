package com.spring.blogone.dto;

import com.spring.blogone.entity.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor@Builder
public class ReplyFindByBlogIdDTO {
    private long replyId;
    private String replyWriter;
    private String replyContent;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;

    public ReplyFindByBlogIdDTO(Reply reply){
        this.replyId = reply.getReplyId();
        this.replyWriter = reply.getReplyWriter();
        this.replyContent = reply.getReplyContent();
        this.publishedAt = reply.getPublishedAt();
        this.updatedAt = reply.getUpdatedAt();
    }
}
