package com.jobtracker.jobtracker.controller;

import com.jobtracker.jobtracker.dto.JobApplicationDto;
import com.jobtracker.jobtracker.entity.JobApplication;
import com.jobtracker.jobtracker.service.JobApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationServiceImpl service;

    @PostMapping
    private JobApplication create(@RequestBody JobApplicationDto dto){
        System.out.println("passed value>> " + dto);
        return service.createApplication(dto);
    }
    @GetMapping
    public List<JobApplication> geAllApplications(@RequestParam int page,
                                                  @RequestParam int size){
        return service.getAllApplications(page, size);
    }
    @GetMapping("/{id}")
    public JobApplication getApplication(@PathVariable Long id){
        return service.getApplication(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.deleteApplication(id);
        return "Deleted Successfully";
    }
    public Page<JobApplication>getApplications(@RequestParam int page,@RequestParam int size){
        return service.getApplications(page, size);
    }

}
