package com.spring.blogone.Service;

import com.spring.blogone.entity.Blog;
import com.spring.blogone.service.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class BlogServiceTest {

    @Autowired
    BlogService blogService;

    @Test
    @Transactional
    @DisplayName("다 가져오기")
    public void findAllTest(){
        List<Blog> list = blogService.findAll();

        assertEquals(3, list.size());
    }

    @Test
    @Transactional
    @DisplayName("2번유저")
    public void findByIdTest(){
        long blogId = 2;
        String writer = "2번유저";

        Blog list = blogService.findById(blogId);

        assertEquals(writer, list.getWriter());
    }

    @Test
    @Transactional
    @DisplayName("2번 블로그 삭제")
    public void deleteByIdTest(){
        long blogId = 2;

        blogService.deleteById(blogId);

        List<Blog> list = blogService.findAll();
        Blog result = blogService.findById(blogId);

        assertEquals(2,list.size());
        assertNull(result);
    }

    @Test
    @Transactional
    @DisplayName("새로운 내용 저장")
    public void saveTest(){
        long blogId = 4;
        String writer = "개똥벌레";
        String content = "뭐지";
        String title = "친구가 없어?";

        Blog blog = Blog.builder()
                .blogId(blogId)
                .writer(writer)
                .blogContent(content)
                .blogTitle(title)
                .build();
        blogService.save(blog);

        List<Blog> list = blogService.findAll();
        Blog result = blogService.findById(blogId);

        assertEquals(4, list.size());
    }

    @Test
    @Transactional
    @DisplayName("2번바꾸기")
    public void updateTest(){
        long blogId = 2;
        String content = "뭐지";
        String title = "친구가 없어?";

        Blog blog = Blog.builder()
                .blogId(blogId)
                .blogContent(content)
                .blogTitle(title)
                .build();
        blogService.update(blog);

        Blog list = blogService.findById(blogId);

        assertEquals(content, list.getBlogContent());
    }
}
