package com.example.skills.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.skills.entity.Shift;
import com.example.skills.service.ShiftService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {
    @Autowired
    ShiftService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shift addShift(@Valid @RequestBody Shift shift){
        return service.addShift(shift);
    }
    @GetMapping
    public List<Shift> getAllShifts(){
        return service.getAllShifts();
    }
    @GetMapping("/{id}")
    public Shift getShiftById(@PathVariable Long id){
        return service.getShiftById(id);
    }
    
    @PutMapping("/{id}")
    public String updateShift(@PathVariable Long id,@Valid @RequestBody Shift shift){
        return service.updateShift(id,shift);

    }
    @DeleteMapping("/{id}")
    public String deleteShift(@PathVariable Long id){
        return service.deleteShift(id);
    }

}
