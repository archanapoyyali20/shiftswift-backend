package com.example.skills.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "shift_assignments")
public class ShiftAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Employee ID cannot be empty")
    private Long employeeId;
     @NotNull(message = "Shift ID cannot be empty")
     private Long shiftId;
     @Enumerated(EnumType.STRING)
     @Column(nullable = false)
    private AssignmentStatus status;

     public ShiftAssignment() {
     }

     public ShiftAssignment(Long id,  Long employeeId,
                            Long shiftId, AssignmentStatus status) {
        this.id = id;
        this.employeeId = employeeId;
        this.shiftId = shiftId;
        this.status = status;
     }

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public Long getEmployeeId() {
         return employeeId;
     }

     public void setEmployeeId(Long employeeId) {
         this.employeeId = employeeId;
     }

     public Long getShiftId() {
         return shiftId;
     }

     public void setShiftId(Long shiftId) {
         this.shiftId = shiftId;
     }

     public AssignmentStatus getStatus() {
         return status;
     }

     public void setStatus(AssignmentStatus status) {
         this.status = status;
     }

     
}
