package com.example.skills.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.skills.entity.LeaveRequest;
import com.example.skills.exception.LeaveRequestNotFoundException;
import com.example.skills.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {
    @Autowired
    LeaveRequestRepository repo;
    public LeaveRequest addRequest(LeaveRequest request){
        return repo.save(request);
    }
    public List<LeaveRequest> getAllRequest(){
        return repo.findAll();
    }
    public LeaveRequest getRequestById(Long id){
        return repo.findById(id).orElseThrow(()->new LeaveRequestNotFoundException("request not found"));
    }
    
    public String updateRequest(Long id, LeaveRequest rq){
        LeaveRequest existing=repo.findById(id).orElseThrow(()->new LeaveRequestNotFoundException("requet not found"));
        existing.setReason(rq.getReason());
        existing.setStartDate(rq.getStartDate());
        existing.setStatus(rq.getStatus());
        repo.save(existing);
         return "requested data updated successfully";

        
    }
    public String deleteRequest(Long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return "request deleted successfully";
        }
        return "request not found";
    }
    
}


