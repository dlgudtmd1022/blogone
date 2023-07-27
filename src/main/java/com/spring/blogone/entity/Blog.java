package com.spring.blogone.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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

    @ColumnDefault("0")
    private Long blogCount;

    @PrePersist
    public void setDefaultValue(){
        this.blogCount = this.blogCount == null ? 0 : this.blogCount;
        this.publishedAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateValue(){
        this.updatedAt = LocalDateTime.now();
    }
}