package com.example.skills.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Employee ID cannot be empty")
    private Long employeeId;
    @NotNull(message = "Shift ID cannot be empty")
    private Long shiftId;
    private LocalDateTime checkIn;
    private LocalDateTime ckeckOut;
    private Double workHours;
    public Attendance() {
    }
    public Attendance(Long id, Long employeeId, Long shiftId, LocalDateTime checkIn, LocalDateTime ckeckOut,
            Double workHours) {
        this.id = id;
        this.employeeId = employeeId;
        this.shiftId = shiftId;
        this.checkIn = checkIn;
        this.ckeckOut = ckeckOut;
        this.workHours = workHours;
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
    public LocalDateTime getCheckIn() {
        return checkIn;
    }
    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }
    public LocalDateTime getCkeckOut() {
        return ckeckOut;
    }
    public void setCkeckOut(LocalDateTime ckeckOut) {
        this.ckeckOut = ckeckOut;
    }
    public Double getWorkHours() {
        return workHours;
    }
    public void setWorkHours(Double workHours) {
        this.workHours = workHours;
    }
    

}
