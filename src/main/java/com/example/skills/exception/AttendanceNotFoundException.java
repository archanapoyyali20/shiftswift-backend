package com.example.skills.exception;

public class AttendanceNotFoundException extends RuntimeException {
    public AttendanceNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
    

