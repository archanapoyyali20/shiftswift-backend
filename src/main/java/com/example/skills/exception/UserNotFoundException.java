package com.example.skills.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
