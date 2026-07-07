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

import com.example.skills.dto.RegisterDTO;
import com.example.skills.dto.UserResponseDTO;
import com.example.skills.entity.User;
import com.example.skills.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService service;
    @PostMapping
public ResponseEntity<?> register(@Valid @RequestBody RegisterDTO dto) {
    UserResponseDTO saved = service.addUser(dto);
    if (saved == null) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}
    
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
    return service.getAllUsers();
}

@GetMapping("/{id}")
public ResponseEntity<?> getUserById(@PathVariable Long id) {
    UserResponseDTO user = service.getUserById(id);
    return ResponseEntity.ok(user);
}
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id,@Valid @RequestBody User user){
        return service.updateUser(id,user);
    }
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Long id){

        return service.deleteUser(id);
    }
    
}
