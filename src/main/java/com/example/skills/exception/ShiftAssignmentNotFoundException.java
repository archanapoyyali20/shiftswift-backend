package com.example.skills.exception;

public class ShiftAssignmentNotFoundException extends RuntimeException {
    public ShiftAssignmentNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
