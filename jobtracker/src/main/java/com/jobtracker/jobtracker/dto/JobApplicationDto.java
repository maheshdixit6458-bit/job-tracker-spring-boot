package com.jobtracker.jobtracker.dto;

import com.jobtracker.jobtracker.entity.Company;
import com.jobtracker.jobtracker.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobApplicationDto {

    private String jobRole;

    private String status;

    private LocalDate appliedDate;

    private UserDto userDto;

    private CompanyDto companyDto;
}
