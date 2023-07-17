package com.spring.blogone.dto;

import com.spring.blogone.entity.Blog;
import lombok.*;

@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class BlogUpdateDTO {

    private long blogId;
    private String writer;
    private String blogTitle;
    private String blogContent;
    public BlogUpdateDTO(Blog blog){
        this.blogId = blog.getBlogId();
        this.writer = blog.getWriter();
        this.blogTitle = blog.getBlogTitle();
        this.blogContent = blog.getBlogContent();
    }
}