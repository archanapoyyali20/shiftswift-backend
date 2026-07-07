package com.example.skills.exception;

public class LeaveRequestNotFoundException extends RuntimeException {
    public LeaveRequestNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
