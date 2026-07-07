package com.example.skills.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.skills.entity.Attendance;
import com.example.skills.service.AttendanceService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    AttendanceService service;
    @PostMapping
    public Attendance addAttendance(@Valid @RequestBody Attendance attendance) {
        return service.addAttendance(attendance);
    }
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return service.getAllAttendance();
    }
    @GetMapping("/{id}")
    public Attendance getAttendanceById(@PathVariable Long id) {
        return service.getAttendanceById(id);
    }
     @PutMapping("/{id}")
    public String updateAttendance(@PathVariable Long id, @Valid @RequestBody Attendance attendance) {
        return service.updateAttendance(id, attendance);
    }

    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable Long id) {
        return service.deleteAttendance(id);
    }
    
    

    
}
