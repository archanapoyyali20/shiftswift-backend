package com.example.skills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.skills.entity.AssignmentStatus;
import com.example.skills.entity.ShiftAssignment;

import com.example.skills.exception.ShiftAssignmentNotFoundException;

import com.example.skills.repository.ShiftAssignmentRepository;
@Service
public class ShiftAssignmentService {
    @Autowired
    ShiftAssignmentRepository repo;
    public ShiftAssignment assignShift(ShiftAssignment assignment){
        return repo.save(assignment);
    }
    public List<ShiftAssignment> getAllAssignment(){
        return repo.findAll();
    }
    public ShiftAssignment getAssignmentById(Long id){
        return repo.findById(id).orElseThrow(()->new ShiftAssignmentNotFoundException("Assignment not found"));
    }
     public List<ShiftAssignment> getByStatus( AssignmentStatus status) {
        return repo.findByStatus(status);
    }
    public String updateAssignment(Long id, ShiftAssignment sh){
        ShiftAssignment existing=repo.findById(id).orElseThrow(()->new ShiftAssignmentNotFoundException("Assignment not found"));
        existing.setStatus(sh.getStatus());
        repo.save(existing);
         return "Assigned data updated successfully";

        
    }
    public String deleteAssignment(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Assignment deleted successfully";
        }
        return "Assignment not found";
    }
    
    

}
