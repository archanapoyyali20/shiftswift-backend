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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.skills.entity.AssignmentStatus;
import com.example.skills.entity.ShiftAssignment;
import com.example.skills.service.ShiftAssignmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/assignments")
public class ShiftAssignmentController {
    @Autowired
    ShiftAssignmentService service;
     @PostMapping
    public ResponseEntity <ShiftAssignment> assignShift(@Valid @RequestBody ShiftAssignment assignment){
        ShiftAssignment saved = service.assignShift(assignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public List<ShiftAssignment> getAllAssignment(){
        return service.getAllAssignment();
    }
    @GetMapping("/{id}")
    public ShiftAssignment getAssignmentById(@PathVariable Long id){
        return service.getAssignmentById(id);
    }
    @GetMapping("/status")
    public List<ShiftAssignment> getByStatus(@RequestParam AssignmentStatus status) {
        return service.getByStatus(status);
    }
    
    @PutMapping("/{id}")
    public String updateAssignment(@PathVariable Long id,@Valid @RequestBody ShiftAssignment assignment){
        return service.updateAssignment(id,assignment);

    }
    @DeleteMapping("/{id}")
    public String deleteAssignment(@PathVariable Long id){
        return service.deleteAssignment(id);
    }


}
