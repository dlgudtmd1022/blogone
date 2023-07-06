package com.spring.blogone.exception;

public class NotFoundBlogIdException extends RuntimeException{

    public NotFoundBlogIdException(String message){
        super(message);
    }
}
