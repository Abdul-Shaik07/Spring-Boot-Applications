package com.java.playstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.java.playstore.Entity.Application;
import com.java.playstore.Repository.ApplicationRepo;
@Service
public class ApplicationService {
    @Autowired
    ApplicationRepo applicationRepo;

    public Application create(Application application) {
        if(applicationRepo.existsById((Long) application.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already, exists");
        }

        return applicationRepo.save(application);


    }
    public List<Application> findByName(String name) {
        return applicationRepo.findByName(name);
    }

}
