package com.jobtracker.jobtracker.service;

import com.jobtracker.jobtracker.dto.CompanyDto;
import com.jobtracker.jobtracker.dto.JobApplicationDto;
import com.jobtracker.jobtracker.dto.UserDto;
import com.jobtracker.jobtracker.entity.Company;
import com.jobtracker.jobtracker.entity.JobApplication;
import com.jobtracker.jobtracker.entity.User;
import com.jobtracker.jobtracker.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class JobApplicationServiceImpl implements JobApplicationService{
    @Autowired
    private JobApplicationRepository repository;
    public Page<JobApplication>getApplications(int page,int size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public JobApplication save(JobApplicationDto job){

        JobApplication jobApplication = new JobApplication();

        User user = new User();
        UserDto userDto = job.getUserDto();
        System.out.println(userDto);

        if(Objects.nonNull(userDto)) {
            user.setEmail(userDto.getEmail());
            user.setName(userDto.getName());
        }

        Company company = new Company();
        CompanyDto companyDto = job.getCompanyDto();
        System.out.println(companyDto);

        if(Objects.nonNull(companyDto)){
            company.setCompanyName(companyDto.getCompanyName());
            company.setLocation(companyDto.getLocation());
        }

        System.out.println(user);
        System.out.println(company);

        jobApplication.setJobRole(job.getJobRole());
        jobApplication.setAppliedDate(job.getAppliedDate());
        jobApplication.setUser(user);
        jobApplication.setCompany(company);
        jobApplication.setStatus(job.getStatus());

        System.out.println(jobApplication);

        return repository.save(jobApplication);
    }
    public List<JobApplication>getAll(){
        return repository.findAll();
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public JobApplication createApplication(JobApplicationDto dto) {
       JobApplication app = new JobApplication();
       app.setJobRole(dto.getJobRole());
       app.setStatus(dto.getStatus());
       app.setAppliedDate(dto.getAppliedDate());
        return repository.save(app);

    }

    @Override
    public List<JobApplication> getAllApplications(int page, int size) {
        return repository.findAll(PageRequest.of(page, size)).getContent();
    }

    @Override
    public JobApplication getApplication(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Application Not Found"));
    }

    @Override
    public void deleteApplication(Long id) {
            repository.deleteById(id);
    }
}
