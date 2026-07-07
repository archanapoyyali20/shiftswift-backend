package com.example.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skills.entity.LeaveRequest;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {

    
} 
    

