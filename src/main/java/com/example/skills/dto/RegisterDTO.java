package com.example.skills.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 30,
          message = "Username must be between 3 and 30 characters")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)" +
                 "(?=.*[@$!%?&])[A-Za-z\\d@$!%?&]{8,}$",
        message = "Password must be 8+ chars with uppercase, " +
                  "lowercase, digit and special character"
    )
    private String password;

    @NotNull(message = "Role cannot be empty")
    private String role;

    @NotBlank(message = "Full name cannot be empty")
    private String fullname;

    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$",message = "Phone must be exactly 10 digits")
    private String phone;

    @NotNull(message = "Department ID cannot be empty")
    private Long departmentId;

    
    public String getUsername() { 
        return username;
     }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
         return password;
         }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() { 
        return role;
     }
    public void setRole(String role) { 
        this.role = role;
     }

    public String getFullname() { 
        return fullname;
     }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() { 
        return email;
     }
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getPhone() { 
        return phone;
     }
    public void setPhone(String phone) { 
        this.phone = phone;
     }

    public Long getDepartmentId() { 
        return departmentId;
     }
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}