package com.spring.blogone.Repository;

import com.spring.blogone.entity.Blog;
import com.spring.blogone.repository.BlogRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class BlogRepositoryTest {

    @Autowired
    BlogRepository blogRepository;


    @Test
    @Transactional
    @DisplayName("전체 행을 얻어옴")
    public void findAll() {

        int blogId = 1;

        List<Blog> blogList = blogRepository.findAll();

        assertEquals(3, blogList.size());

        assertEquals(2, blogList.get(blogId).getBlogId());
    }

    @Test
    @Transactional
    @DisplayName("원하는 번호를 블로그 얻어오기")
    public void findByIdTest() {
        long blogId = 2;

        Blog result = blogRepository.findById(blogId);

        assertEquals("2번유저", result.getWriter());
    }

    @Test
    @Transactional
    @DisplayName("내 맘속에 저장~")
    public void saveTest(){
        long blogId = 4;
        String writer = "개똥벌레";
        String title = "친구가 없네~";
        String content = "나는 개똥벌레~ 친구가 없네~";

        Blog blog = Blog.builder()
                .writer(writer)
                .blogTitle(title)
                .blogContent(content)
                .build();

        blogRepository.save(blog);

        Blog result = blogRepository.findById(blogId);
        List<Blog> blogList = blogRepository.findAll();

//        assertEquals(writer,result.getWriter());

        assertEquals(writer,blogList.get(3).getWriter());
    }

    @Test
    @Transactional
    @DisplayName("삭제했다용")
    public void deleteByIdTest(){
        long blogId = 2;

        blogRepository.deleteById(blogId);

        assertEquals(2, blogRepository.findAll().size());
    }

    @Test
    @Transactional
    @DisplayName("변경 완료!")
    public void updateTest(){
        long blogId = 2;
        String title = "여가 아닌가";
        String content = "아니니까 돌아가쇼";

        Blog blog = Blog.builder()
                .blogId(blogId)
                .blogTitle(title)
                .blogContent(content)
                .build();

        blogRepository.update(blog);
        List<Blog> result = blogRepository.findAll();
        Blog list = blogRepository.findById(blogId);
        assertEquals(3,result.size());
        assertEquals(title,list.getBlogTitle());
    }
}