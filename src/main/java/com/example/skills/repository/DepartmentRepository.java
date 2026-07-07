package com.example.skills.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.skills.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

    
}
    

