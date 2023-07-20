package com.spring.blogone.controller;

import com.spring.blogone.dto.ReplyCreateRequestDTO;
import com.spring.blogone.dto.ReplyFindByIdDTO;
import com.spring.blogone.exception.NotFoundReplyByReplyIdException;
import com.spring.blogone.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    ReplyService replyService;

    @Autowired
    public ReplyController(ReplyService replyService){
        this.replyService = replyService;
    }

    @GetMapping("/{blogId}/all")
    // rest서버는 응답시 응답코드와 응답객체를 넘기기 때문에 ResponseEntity<자료형>
    // 을 리턴합니다.
    public ResponseEntity<List<ReplyFindByIdDTO>> findAllReplies(
            @PathVariable long blogId){
        // 서비스에서 리플 목록을 들고옵니다.
        List<ReplyFindByIdDTO> replies = replyService.findAllByBlogId(blogId);

        return ResponseEntity
                .ok()//replies);   // 200코드, 상태 코드와 body에 전송할 데이터를 같이 작성할수도 있음.
                .body(replies); // 리플목록
    }

    @GetMapping("/{replyId}")
    public ResponseEntity<?> finByReplyId(@PathVariable long replyId){

        ReplyFindByIdDTO replyFindByIdDTO = replyService.findByReplyId(replyId);

        try{
            if(replyFindByIdDTO == null){
                throw new NotFoundReplyByReplyIdException("없는 댓글 번호를 조회했습니다.");
            }
            //        return new ResponseEntity<ReplyFindByIdDTO>(replyFindByIdDTO, HttpStatus.OK);
            return ResponseEntity.ok(replyFindByIdDTO);
        } catch (NotFoundReplyByReplyIdException e){
            e.printStackTrace();
            return new ResponseEntity<>("찾는 댓글 번호가 없습니다.", HttpStatus.NOT_FOUND);
        }
    }

    //  save는 post로
    @PostMapping("")
    public ResponseEntity<String> insertReply(@RequestBody ReplyCreateRequestDTO ReplyCreateRequestDTO){
        replyService.save(ReplyCreateRequestDTO);
        return ResponseEntity.ok("댓글 등록이 잘 되었습니다.");
    }

    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity<String> deleteReply(@PathVariable long replyId){
        replyService.deleteByReplyId(replyId);
        return ResponseEntity.ok("댓글 삭제 완료!");
    }
}
