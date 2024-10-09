package com.nsworld.globalexception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
