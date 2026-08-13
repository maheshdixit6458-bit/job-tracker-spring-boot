package com.jobtracker.jobtracker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String jobRole;

    private String status;

    private LocalDate appliedDate;

    @ManyToOne
    private User user;

   @ManyToOne
    private Company company;
}
