package com.example.skills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skills.entity.Department;
import com.example.skills.exception.DepartmentNotFoundException;
import com.example.skills.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repo;
    public Department addDepartment(Department department){
       return repo.save(department);
        
    }
    public List<Department> getAllDepartments(){
        return repo.findAll();
    }
    public Department getDepartmentById(Long id){
        return repo.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
        
        
    }
    public String updateDepartment(Long id,Department dept){
        Department existing=repo.findById(id).orElseThrow(()->new DepartmentNotFoundException("Department not found"));
        
            existing.setName(dept.getName());
            existing.setDescription(dept.getDescription());
            repo.save(existing);
            return "department updated successfully";
            
        
    }
    public String deleteDepartment(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "Department deleted successfully";
        }
        return "Department not found";
    }
}
