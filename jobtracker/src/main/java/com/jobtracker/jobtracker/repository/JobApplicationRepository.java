package com.jobtracker.jobtracker.repository;

import com.jobtracker.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {
    List<JobApplication> findByStatus(String status);

    List<JobApplication> findByJobRoleContaining(String keyword);
}

