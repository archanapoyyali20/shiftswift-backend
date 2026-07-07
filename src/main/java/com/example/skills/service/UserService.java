package com.example.skills.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.skills.dto.RegisterDTO;
import com.example.skills.dto.UserResponseDTO;
import com.example.skills.entity.Role;
import com.example.skills.entity.User;
import com.example.skills.exception.UserNotFoundException;
import com.example.skills.repository.UserRepository;
import com.example.skills.security.JwtService;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    
    private UserResponseDTO convertToDTO(User user) {
        return new UserResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getRole().name(),
            user.getFullname(),
            user.getEmail(),
            user.getPhone(),
            user.getDepartmentId()
        );
    }

    
    public UserResponseDTO addUser(RegisterDTO dto) {

        
        if (repo.existsByUsername(dto.getUsername())) {
            return null;
        }

        
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword())); 
        user.setRole(Role.valueOf(dto.getRole()));
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setDepartmentId(dto.getDepartmentId());

        
        User saved = repo.save(user);

        
        return convertToDTO(saved);
    }

    
    public String login(User user) {

        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                user.getUsername(),
                user.getPassword()
            )
        );

        if (auth.isAuthenticated()) {
            User dbUser = repo.findByUsername(user.getUsername())
                .orElseThrow(() -> new UserNotFoundException(
                    "User not found"));
            return jwtService.generateToken(dbUser);
        }

        return "Invalid username or password";
    }

   
    public List<UserResponseDTO> getAllUsers() {
        return repo.findAll()
            .stream()
            .map(this::convertToDTO) 
            .collect(Collectors.toList());
    }

    
    public UserResponseDTO getUserById(Long id) {
        User user = repo.findById(id)
            .orElseThrow(() -> new UserNotFoundException(
                "User not found"));
        return convertToDTO(user);
    }

   
    public User findByUsername(String username) {
        return repo.findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException(
                "User not found"));
    }

    
    public String updateUser(Long id, User user) {
        User existing = repo.findById(id)
            .orElseThrow(() -> new UserNotFoundException(
                "User not found"));

        existing.setFullname(user.getFullname());
        existing.setEmail(user.getEmail());
        existing.setPhone(user.getPhone());
        existing.setDepartmentId(user.getDepartmentId());

        repo.save(existing);
        return "User updated successfully";
    }

    
    public String deleteUser(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }
}