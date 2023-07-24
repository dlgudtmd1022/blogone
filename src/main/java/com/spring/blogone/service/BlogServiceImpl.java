package com.spring.blogone.service;

import com.spring.blogone.entity.Blog;
import com.spring.blogone.repository.BlogJPARepository;
import com.spring.blogone.repository.BlogRepository;
import com.spring.blogone.repository.ReplyJPARepository;
import com.spring.blogone.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    BlogRepository blogRepository;

    ReplyRepository replyRepository;

    BlogJPARepository blogJPARepository;

    ReplyJPARepository replyJPARepository;


    @Autowired // 생성자 주입이 속도가 더 빠름.
    public BlogServiceImpl(BlogRepository blogRepository, BlogJPARepository blogJPARepository, ReplyRepository replyRepository, ReplyJPARepository replyJPARepository){
        this.blogRepository = blogRepository;
        this.blogJPARepository = blogJPARepository;
        this.replyRepository = replyRepository;
        this.replyJPARepository = replyJPARepository;
    }

    @Override
    public Page<Blog> findAll(Long pageNum) { // 페이지 정보를 함께 포함하고 있는 리스트인 Page를 리턴해야함
        //List<Blog> blogList = blogRepository.findAll();
        //return blogList;
        //return blogRepository.findAll();//<- Mybatis를 활용한 전체 글 가져오기
        //return blogJPARepository.findAll(); //<- JPA를 활용한 전체 글 가져오기

        int calibratedPageNum = getCalibratedPageNum(pageNum);

        // 페이징 처리에 관련된 정보를 먼저 객체로 생성합니다.
        Pageable pageable = PageRequest.of((calibratedPageNum - 1), 10);
        // 생성된 페이징 정보를 파라미터로 제공해서 findAll()을 호출합니다.
        return blogJPARepository.findAll(pageable);

    }

    @Override
    public Blog findById(long blogId) {

//        return blogRepository.findById(blogId);
        return blogJPARepository.findById(blogId).get();
    }

    @Override
    public void deleteById(long blogId) {
//        blogRepository.deleteById(blogId);
//        replyJPARepository.deleteById(blogId);
        blogJPARepository.deleteById(blogId);
    }

    @Override
    public void save(Blog blog) {
        //blogRepository.save(blog);
        blogJPARepository.save(blog);
    }

    @Override
    public void update(Blog blog) {

        Blog updatedBlog = blogJPARepository.findById(blog.getBlogId()).get();

        updatedBlog.setBlogTitle(blog.getBlogTitle());
        updatedBlog.setBlogContent(blog.getBlogContent());

        blogJPARepository.save(updatedBlog);
    }

    // 보정된 pageNum으로 가공해주는 메서드
    public int getCalibratedPageNum(Long pageNum){
        // 사용자가 음수를 넘겼거나 아무것도 안 넣은 경우
        if(pageNum == null || pageNum <= 0L){
            pageNum = 1L;
        } else {
            // 총 페이지 개수를 구하는 로직
            int totalPagesCount = (int) Math.ceil(blogJPARepository.count() / 10.0);

            pageNum = pageNum > totalPagesCount ? totalPagesCount : pageNum;
        }
        return pageNum.intValue();
    }
}
