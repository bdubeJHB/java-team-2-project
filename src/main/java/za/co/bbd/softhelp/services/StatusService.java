package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.Models.Status;
import za.co.bbd.softhelp.Repository.StatusRepository;

import java.util.Optional;

@Service
public class StatusService {
    final private StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public String getStatus(Long statusId){
        Optional<Status> status = statusRepository.findById(statusId);

        if(status.isEmpty()){
            throw new IllegalStateException("Status does not exist");
        }
       return status.get().getStatus();
    }

    public Long getStatusId(Long statusId){
        Optional<Status> status = statusRepository.findById(statusId);

        if(status.isEmpty()){
            throw new IllegalStateException("Status ID does not exist");
        }
        return status.get().getStatusId();
    }
}
