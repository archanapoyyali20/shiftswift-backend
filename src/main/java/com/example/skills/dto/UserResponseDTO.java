package com.example.skills.dto;

public class UserResponseDTO {

    private Long id;
    private String username;
    private String role;
    private String fullname;
    private String email;
    private String phone;
    private Long departmentId;

    
    public UserResponseDTO(Long id, String username, String role,String fullname,
                             String email, String phone, Long departmentId) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.departmentId = departmentId;
    }

   
    public Long getId() { 
        return id;
     }
    public String getUsername() {
         return username; 
        }
    public String getRole() { 
        return role; 
    }
    public String getFullname() {
         return fullname;
         }
    public String getEmail() { 
        return email; 
    }
    public String getPhone() {
         return phone;
         }
    public Long getDepartmentId() { 
        return departmentId;
     }
}