package com.jobtracker.jobtracker.service;

import com.jobtracker.jobtracker.dto.JobApplicationDto;
import com.jobtracker.jobtracker.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {
    JobApplication createApplication(JobApplicationDto dto);
    List<JobApplication> getAllApplications(int page,int size);
    JobApplication getApplication(Long id);
    void deleteApplication(Long id);
}
