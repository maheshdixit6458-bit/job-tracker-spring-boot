package com.jobtracker.jobtracker.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public  String handlerException(ResourceNotFoundException ex){
        return ex.getMessage();
    }
}
