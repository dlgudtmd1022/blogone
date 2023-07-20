package com.spring.blogone.Service;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.dto.ReplyUpdateDTO;
import com.spring.blogone.service.ReplyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
public class ReplyServiceTest {

    @Autowired
    ReplyService replyService;

    @Test
    @Transactional
    @DisplayName("전체 찾기")
    public void findAllByBlogIdTest(){
        long blogId = 2;

        List<ReplyFindByIdDTO> result = replyService.findAllByBlogId(blogId);

        assertEquals(4, result.size());
    }

    @Test
    @Transactional
    @DisplayName("하나 찾기")
    public void findByReplyId(){
        long replyId = 2;

        ReplyFindByIdDTO result = replyService.findByReplyId(replyId);

        assertEquals("짹짹이", result.getReplyWriter());
    }

    @Test
    @Transactional
    @DisplayName("삭제")
    public void deleteByReplyId(){
        long replyId = 2;
        long blogId = 2;
        replyService.deleteByReplyId(replyId);

        assertEquals(3, replyService.findAllByBlogId(blogId).size());
    }

    @Test
    @Transactional
    @DisplayName("추가")
    public void saveTest(){
        long blogId = 1;
        String writer = "개똥벌레";
        String content = "친구가 없네";

        ReplyCreateRequestDTO reply = ReplyCreateRequestDTO.builder()
                .blogId(blogId)
                .replyWriter(writer)
                .replyContent(content)
                .build();

        replyService.save(reply);

        assertEquals(1,replyService.findAllByBlogId(blogId).size());
    }

    @Test
    @Transactional
    @DisplayName("업데이트")
    public void updateTest(){
        long replyId = 3;
        String writer = "개똥벌레";
        String content = "친구가 없네";

        ReplyUpdateDTO result = ReplyUpdateDTO.builder()
                .replyId(replyId)
                .replyWriter(writer)
                .replyContent(content)
                .build();

        replyService.update(result);
        ReplyFindByIdDTO reply = replyService.findByReplyId(replyId);
        assertEquals(writer, reply.getReplyWriter());
    }
}

