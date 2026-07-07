package com.example.skills.exception;

public class ShiftNotFoundException extends RuntimeException{
    public ShiftNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
