package com.spring.blogone.Repository;

import com.spring.blogone.dto.ReplyFindByBlogIdDTO;
import com.spring.blogone.entity.Reply;
import com.spring.blogone.repository.ReplyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class ReplyRepositoryTest {

    @Autowired
    ReplyRepository replyRepository;

    @Test
    @Transactional
    @DisplayName("전체 찾기")
    public void findAllByBlogIdDTOTest(){

        long blogId = 3;

        List<ReplyFindByBlogIdDTO> replyList = replyRepository.findAllByBlogId(blogId);

        assertEquals(1, replyList.size());
    }

    @Test
    @Transactional
    @DisplayName("댓글 번호로 하나 찾기")
    public void findByReplyId(){
        long replyId = 2;
        ReplyFindByBlogIdDTO reply = replyRepository.findByReplyId(replyId);

        assertEquals("짹짹이", reply.getReplyWriter());
        assertEquals("짹짹쨲쨲쨲쨰꺠ㅉ꺠ㅉㄲㅉ꺢", reply.getReplyContent());
    }

    @Test
    @Transactional
    @DisplayName("삭제")
    public void deleteByReplyIdTest(){
    long replyId = 3;
    long blogId = 2;

    replyRepository.deleteByReplyId(replyId);
    List<ReplyFindByBlogIdDTO> result = replyRepository.findAllByBlogId(blogId);

    assertEquals(3, result.size());
    assertEquals("댓글쓴사람", result.get(0).getReplyWriter());
    assertNull(replyRepository.findByReplyId(replyId));
    }

    @Test
    @Transactional
    @DisplayName("추가")
    public void saveTest(){
        long blogId = 1;
        String replyWriter = "개똥벌레";
        String replyContent = "친구가 없네";

        Reply reply =  Reply.builder()
                .blogId(blogId)
                .replyWriter(replyWriter)
                .replyContent(replyContent)
                .build();
        replyRepository.save(reply);

        assertEquals(1, replyRepository.findAllByBlogId(blogId).size());
        assertEquals("개똥벌레", replyRepository.findAllByBlogId(blogId).get(0).getReplyWriter());
    }

    @Test
    @Transactional
    @DisplayName("글 수정")
    public void updateTest(){
        long replyId = 3;
        String replyWriter = "개똥벌레";
        String replyContent = "친구가 없네";

        Reply reply =  Reply.builder()
                .replyId(replyId)
                .replyWriter(replyWriter)
                .replyContent(replyContent)
                .build();

        replyRepository.update(reply);

        assertEquals(replyWriter,replyRepository.findByReplyId(replyId).getReplyWriter());
        assertEquals(replyContent, replyRepository.findByReplyId(replyId).getReplyContent());
    }

}
