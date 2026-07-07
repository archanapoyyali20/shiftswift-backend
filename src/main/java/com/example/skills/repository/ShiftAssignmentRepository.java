package com.example.skills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skills.entity.AssignmentStatus;
import com.example.skills.entity.ShiftAssignment;

public interface ShiftAssignmentRepository extends JpaRepository<ShiftAssignment,Long> {

    List<ShiftAssignment> findByStatus(AssignmentStatus status);
} 
    

