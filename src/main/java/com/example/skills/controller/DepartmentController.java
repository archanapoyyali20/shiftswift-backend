package com.example.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skills.entity.Department;
import com.example.skills.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
     public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department){
        Department saved=service.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping("/dept")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER','EMPLOYEE')")
    public List<Department> getAllDepartments(){
        return service.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return service.getDepartmentById(id);
    }
    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable Long id,@Valid @RequestBody Department dept){
        return service.updateDepartment(id,dept);
    }
    @DeleteMapping("{id}")
    public String deleteDepartment(@PathVariable Long id){

        return service.deleteDepartment(id);
    }
}
