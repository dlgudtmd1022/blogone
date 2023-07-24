package com.spring.blogone.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter@ToString@Setter
@NoArgsConstructor@AllArgsConstructor@Builder
@Entity
public class Reply {

    @Id
    @Column(nullable = false)
    private long replyId;
    @Column(nullable = false)
    private long blogId;
    @Column(nullable = false)
    private String replyWriter;
    @Column(nullable = false)
    private String replyContent;
    private LocalDateTime publishedAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void setDefaultValue(){
        this.publishedAt = LocalDateTime.parse("YYY:mm:DD HH:MM:SS");
        this.updatedAt = LocalDateTime.parse("YYY:mm:DD HH:MM:SS");
    }

    @PreUpdate
    public void setUpdatedAt(){
            this.updatedAt = LocalDateTime.parse("YYYY:mm:DD HH:MM:SS");
    }
}
