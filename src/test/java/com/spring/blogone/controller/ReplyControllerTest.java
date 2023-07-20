package com.spring.blogone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.entity.Reply;
import com.spring.blogone.repository.ReplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ReplyRepository replyRepository;

    @BeforeEach
    public void setMockMvc(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @Transactional
    @DisplayName("2번 글에 대한 전체 댓글을 가져왔니,,?")
    void findAllReplies() throws Exception{
        String url = "/reply/2/all";

        String writer = "댓글쓴사람";

        long replyId = 1;

        // 위에 설정한 url로 접속 후 json 데이터 리턴받아 젖아하기. ResultActions 형 자료로 json저장하기
        final ResultActions result = mockMvc.perform(get(url)
                                               .accept(MediaType.APPLICATION_JSON));//

        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].replyWriter").value(writer))
                .andExpect(jsonPath("$[0].replyId").value(replyId));
    }

    @Test
    @Transactional
    @DisplayName("2번 댓글 찾기")
    public void findByReplyIdTest() throws Exception{
        long replyId = 2;
        String writer = "짹짹이";
        String url = "/reply/2";

        final ResultActions result = mockMvc.perform(get(url)
                                            .accept(MediaType.APPLICATION_JSON));

        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("replyWriter").value(writer))
                .andExpect(jsonPath("replyId").value(replyId));
    }

    @Test
    @Transactional
    @DisplayName("1번 블로그에 개똥벌레라는 이름으로 나는 개똥벌레~ 친구가 없네~ 댓글 추가")
    public void insertReplyTest() throws Exception{
        // given
        String replyWriter = "개똥벌레";
        String replyContent = "나는 개똥벌레~ 친구가 없네~";
        long blogId = 1;
        String url = "/reply";
        String url2 = "/reply/1/all";


        ReplyCreateRequestDTO replyInsertDTO = ReplyCreateRequestDTO.builder()
                .blogId(blogId)
                .replyWriter(replyWriter)
                .replyContent(replyContent)
                .build();

        // 데이터 직렬화
        final String requestBody = objectMapper.writeValueAsString(replyInsertDTO);


        // 보내기
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)); // 위에서 직렬화한 requestBody 변수를 전달할것이다.

        // 가져오기
        final ResultActions result = mockMvc.perform(get(url2)
                .accept(MediaType.APPLICATION_JSON));

        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].replyWriter").value(replyWriter))
                .andExpect(jsonPath("$[0].replyContent").value(replyContent));
    }

    @Test
    @Transactional
    @DisplayName("삭제")
    public void deleteReplyTest()throws Exception{
        long blogId = 2;
        long replyId = 3;
        String url = "/reply/3";

        mockMvc.perform(delete(url).accept(MediaType.TEXT_PLAIN));

        List<ReplyFindByIdDTO> result = replyRepository.findAllByBlogId(blogId);
        assertEquals(4,result.size());
//        ReplyFindByIdDTO reply = replyRepository.findByReplyId(replyId);
//        assertNull(reply);
    }
}