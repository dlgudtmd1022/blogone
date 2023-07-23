package com.spring.blogone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Blog {

    @Id
    private long blogId;
    private String writer;
    private String blogTitle;
    private String blogContent;

    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;
    private long blogCount;
}