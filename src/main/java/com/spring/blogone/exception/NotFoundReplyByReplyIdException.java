package com.spring.blogone.exception;

public class NotFoundReplyByReplyIdException extends RuntimeException{

    public NotFoundReplyByReplyIdException(String message){
        super(message);
    }
}
