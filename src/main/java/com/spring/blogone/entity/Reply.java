package com.spring.blogone.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter@ToString
@NoArgsConstructor@AllArgsConstructor@Builder
public class Reply {
    private long replyId;
    private long blogId;
    private String replyWriter;
    private String replyContent;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;
}
