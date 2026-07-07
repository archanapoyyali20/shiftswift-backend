package com.example.skills.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skills.dto.LoginDTO;
import com.example.skills.dto.RegisterDTO;
import com.example.skills.dto.UserResponseDTO;
import com.example.skills.entity.User;
import com.example.skills.security.JwtService;
import com.example.skills.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    public AuthController(
            UserService userService,
            AuthenticationManager authenticationManager,
            JwtService jwtService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
public ResponseEntity<?> register(
        @Valid @RequestBody RegisterDTO dto) { // ← RegisterDTO now
    UserResponseDTO saved = userService.addUser(dto);
    if (saved == null) {
        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body("Username already exists");
    }
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(saved);
}

@PostMapping("/login")
public ResponseEntity<String> login(
        @Valid @RequestBody LoginDTO dto) { // ← LoginDTO now
    Authentication auth = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            dto.getUsername(),
            dto.getPassword()
        )
    );
    if (auth.isAuthenticated()) {
        User dbUser = userService.findByUsername(dto.getUsername());
        String token = jwtService.generateToken(dbUser);
        return ResponseEntity.ok(token);
    }
    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body("Invalid username or password");
}
}