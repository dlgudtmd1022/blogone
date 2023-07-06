<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
    div{
        border: 1px solid black;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/blog/updateform" method="POST">
    <div class="row first-row">
        <div class="col">
            글번호
        </div>
        <div class="col">
            ${blog.blogId}
        </div>
        <div class="col">
            글제목
        </div>
        <div class="col">
            ${blog.blogTitle}
        </div>
        <div class="col">
            글제목
        </div>
        <div class="col">
            ${blog.blogTitle}
        </div>
    </div>
    <div class="row second-row">
        <div class="col-2">
            본문
        </div>
        <div class="col-8">
            ${blog.blogContent}
        </div>
        <div class="col">
            작성날짜
        </div>
        <div class="col">
            ${blog.publishedAt}
        </div>
    </div>
    <div class="row">
        <div class="col-2">
            <a href="/blog/list"><button class="btn btn-secondary">목록으로</button> </a>
        </div>
        <div class="col-2">
            <form action="/blog/delete" method="POST">
                <input type="hidden" name="blogId" value="${blog.blogId}">
                <input type="submit" class="btn btn-warning" value="삭제하기">
            </form>
            <form action="/blog/updateform" method="POST">
                <input type="hidden" name="blogId" value="${blog.blogId}">
                <input type="submit" class="btn btn-warning" value="수정하기">
            </form>
        </div>
    </div>
    </form>
</div>
</body>
</html>