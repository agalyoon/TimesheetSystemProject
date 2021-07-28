package com.training.disasterproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.disasterproject.model.Job;
import com.training.disasterproject.model.User;

public interface JobRepository extends JpaRepository<Job,String>{
	List<Job> findByUser(User user);
}
