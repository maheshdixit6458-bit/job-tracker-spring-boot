package com.jobtracker.jobtracker.repository;

import com.jobtracker.jobtracker.entity.Company;
import com.jobtracker.jobtracker.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}

