package com.training.disasterproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.disasterproject.model.Job;

public interface JobRepository extends JpaRepository<Job,String>{

}
