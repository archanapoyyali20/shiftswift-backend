package com.example.skills.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
    

