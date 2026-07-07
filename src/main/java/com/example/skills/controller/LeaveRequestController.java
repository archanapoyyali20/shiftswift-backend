package com.example.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skills.entity.LeaveRequest;
import com.example.skills.service.LeaveRequestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {
    @Autowired
    LeaveRequestService service;
    
    @PostMapping
    public ResponseEntity <LeaveRequest> addRequest(@Valid @RequestBody LeaveRequest request){
        LeaveRequest saved = service.addRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public List<LeaveRequest> getAllRequest(){
        return service.getAllRequest();
    }
    @GetMapping("/{id}")
    public LeaveRequest getRequestById(@PathVariable Long id){
        return service.getRequestById(id);
    }
    
    @PutMapping("/{id}")
    public String updateRequest(@PathVariable Long id,@Valid @RequestBody LeaveRequest request){
        return service.updateRequest(id,request);

    }
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id){
        return service.deleteRequest(id);
    }

}


