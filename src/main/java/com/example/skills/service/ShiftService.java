package com.example.skills.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skills.entity.Shift;
import com.example.skills.exception.ShiftNotFoundException;
import com.example.skills.repository.ShiftRepository;

@Service
public class ShiftService {
    @Autowired
    ShiftRepository repo;
    public Shift addShift(Shift shift){
        return repo.save(shift);
    }
    public List<Shift> getAllShifts(){
        return repo.findAll();
    }
    public Shift getShiftById(Long id){
        return repo.findById(id).orElseThrow(()->new ShiftNotFoundException("shift not found"));
    }
    
    public String updateShift(Long id,Shift sh){
        Shift existing=repo.findById(id).orElseThrow(()->new ShiftNotFoundException("shift not found"));
        existing.setShiftName(sh.getShiftName());
        existing.setStartTime(sh.getStartTime());
        existing.setEndTime(sh.getEndTime());
        existing.setDate(sh.getDate());
         repo.save(existing);
         return "shift data updated successfully";
    }
    public String deleteShift(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "shift deleted successfully";
        }
        return "shift not found";
    }
    
}
