<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        div {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<div class="container">
    <!-- 모달 자리 -->
    <div class="modal fade" id="replyUpdateModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">댓글 수정하기</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    작성자 : <input type="text" class="form-control" id="modalReplyWriter"><br>
                    댓글내용 : <input type="text" class="form-control" id="modalReplyContent">
                    <input type="hidden" id="modalReplyId" value="">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="replyUpdateBtn">수정하기</button>
                </div>
            </div>
        </div>
    </div>



    <div class="row first-row">
        <div class="col-1">
            글번호
        </div>
        <div class="col-1">
            ${blog.blogId}
        </div>
        <div class="col-2">
            글제목
        </div>
        <div class="col-4">
            ${blog.blogTitle}
        </div>
        <div class="col-1">
            작성자
        </div>
        <div class="col-1">
            ${blog.writer}
        </div>
        <div class="col-1">
            조회수
        </div>
        <div class="col-1">
            ${blog.blogCount}
        </div>
    </div><!--.first-row-->
    <div class="row second-row">
        <div class="col-1">
            작성일
        </div>
        <div class="col-5">
            ${blog.publishedAt}
        </div>
        <div class="col-1">
            수정일
        </div>
        <div class="col-5">
            ${blog.updatedAt}
        </div>
    </div><!-- .row second -->
    <div class="row third-row">
        <div class="col-1">
            본문
        </div>
        <div class="col-11">
            ${blog.blogContent}
        </div>
    </div><!-- .row third -->
    <div class="row fourth-row">
        <div class="col-2">
            <a href="/blog/list"><button class="btn btn-secondary">목록으로</button></a>
        </div>
        <div class="col-2">
            <form action="/blog/delete" method="POST">
                <input type="hidden" name="blogId" value="${blog.blogId}">
                <input type="submit" value="삭제하기" class="btn btn-warning">
            </form>
        </div>
        <div class="col-2">
            <form action="/blog/updateform" method="POST">
                <input type="hidden" name="blogId" value="${blog.blogId}">
                <input type="submit" value="수정하기" class="btn btn-info">
            </form>
        </div>
    </div><!-- .row fourth -->
    <div class="row">
        <div id="replies">

        </div>
    </div>
</div>
<script>
    let blogId = "${blog.blogId}"

    function getAllReplies(id){

        let url = `http://localhost:8080/reply/\${id}/all`;

        let str = "";

        fetch(url, {method:'get'})
            .then((res) => res.json())
            .then(replies => {
                console.log(replies);
                // for(reply of replies){
                //     console.log(reply);
                //     console.log("---------");
                //     str += `<h3>글쓴이: \${reply.replyWriter}, 댓글내용: \${reply.replyContent}</h3>`;
                // }
                console.log(str);

                replies.map((reply, i) => {
                    str += `<h3> \${i + 1}번째 댓글 || 글쓴이: \${reply.replyWriter}, 댓글내용: \${reply.replyContent}</h3>`;
                });

                const $replies = document.getElementById('replies');

                $replies.innerHTML = str;

            });
    }
    getAllReplies(blogId);

</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>