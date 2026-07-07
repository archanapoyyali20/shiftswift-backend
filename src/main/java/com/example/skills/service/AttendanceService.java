package com.example.skills.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.skills.entity.Attendance;
import com.example.skills.exception.AttendanceNotFoundException;
import com.example.skills.repository.AttendanceRepository;
@Service
public class AttendanceService {

    @Autowired
    AttendanceRepository repo;
    public Attendance addAttendance(Attendance attendance) {
        return repo.save(attendance);
    }
    public List<Attendance> getAllAttendance() {
        return repo.findAll();
    }
    public Attendance getAttendanceById(Long id) {
        return repo.findById(id).orElseThrow(() ->new AttendanceNotFoundException("Attendance not found"));
    }
    public String updateAttendance(Long id, Attendance attendance) {
        Attendance existing = repo.findById(id).orElseThrow(() ->new AttendanceNotFoundException("Attendance not found"));
        existing.setEmployeeId(attendance.getEmployeeId());
        existing.setShiftId(attendance.getShiftId());
        existing.setCheckIn(attendance.getCheckIn());
        existing.setCkeckOut(attendance.getCkeckOut());
         repo.save(existing);
         return "Attendance updated successfully";
    }

    public String deleteAttendance(Long id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Attendance deleted successfully";
        }

        return "Attendance not found";
    }
}
