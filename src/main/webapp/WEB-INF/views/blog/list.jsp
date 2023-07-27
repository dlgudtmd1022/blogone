<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text">게시물 목록</h1>
    <table class="table table-hover">
        <thead>
            <td>글번호</td>
            <td>글제목</td>
            <td>글쓴이</td>
            <td>작성일</td>
            <td>수정일</td>
            <td>조회수</td>
        </thead>
        <tbody>
            <c:forEach var="blog" items="${blogList.toList()}">
                <tr>
                    <td><a href="/blog/detail/${blog.blogId}">${blog.blogId}</a></td>
                    <td>${blog.blogTitle}</td>
                    <td>${blog.writer}</td>
                    <td>${blog.publishedAt}</td>
                    <td>${blog.updatedAt}</td>
                    <td>${blog.blogCount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="col-1">
        <a href="/blog/insert" class="btn btn-primary">글쓰기</a>
    </div>
</div>
</body>
</html>
