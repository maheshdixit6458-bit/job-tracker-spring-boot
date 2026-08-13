package com.jobtracker.jobtracker.repository;

import com.jobtracker.jobtracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
