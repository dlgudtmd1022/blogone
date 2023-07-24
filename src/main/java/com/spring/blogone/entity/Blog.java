package com.spring.blogone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long blogId;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String blogTitle;
    @Column(nullable = false)
    private String blogContent;

    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;
    private long blogCount;
}