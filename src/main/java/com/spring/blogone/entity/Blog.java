package com.spring.blogone.entity;

import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class Blog {

    private long blogId;
    private String writer;
    private String blogTitle;
    private String blogContent;

    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;
    private long blogCount;

}