package com.example.skills.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<String >handleDepartment(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
     @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String >handleUser(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(ShiftNotFoundException.class)
     public ResponseEntity<String> handleShift(Exception e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(AttendanceNotFoundException.class)
    public ResponseEntity<String> handleAttendance(Exception e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
     @ExceptionHandler(LeaveRequestNotFoundException.class)
     public ResponseEntity<String> handleLeaveRequest(Exception e) {
    return ResponseEntity .status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(ShiftAssignmentNotFoundException.class)
    public ResponseEntity<String> handleShiftAssignment(Exception e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
}
  @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentials(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
    @ExceptionHandler(AccessDeniedException.class)
public ResponseEntity<String> handleAccessDenied(AccessDeniedException e) {
    return ResponseEntity.status(HttpStatus.FORBIDDEN)
        .body("You do not have permission to perform this action");
}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validateField(MethodArgumentNotValidException ex){
        Map<String,String>error=new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(err->error.put(err.getField(),err.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
