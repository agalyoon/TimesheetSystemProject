package com.training.disasterproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.disasterproject.exception.RecordExistsException;
import com.training.disasterproject.exception.RecordNotFoundException;
import com.training.disasterproject.model.Job;
import com.training.disasterproject.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	private JobRepository jobRepo;
	
	public Job findJobByCode(String code) {
		return jobRepo.getOne(code);
	}
	public void addJob(Job job) {
		jobRepo.save(job);
	}
	public List<Job> getAllJobs()
	{
		return jobRepo.findAll();
	}

	public Optional<Job> get(String code)
	{
		return jobRepo.findById(code);
	}
	
	public void add(Job job) 
	{
		
		jobRepo.save(job);
	}

	/*
	public void add(Job job) throws RecordExistsException
	{
		if (job.getCode() == null)
		{
			throw new IllegalArgumentException("Job code cannot be null");
		}
		Optional<Job> optJob = jobRepo.findById(job.getCode());
		if (optJob.isPresent())
		{
			throw new RecordExistsException("Job code '" + job.getCode() + "' exists");
		}
		
		*/
	
	/**
	 *  Updates the Job with the given job.code, 
	 *  making sure Job exists
	 * @param job
	 * @throws JobNotFoundException
	 */
		
/*	
	public void update(Job job) throws RecordNotFoundException
	{
		jobRepo.findById(job.getCode())
				.orElseThrow(() -> new RecordNotFoundException("Job '" + job.getCode() + "'not found"));
	
	}
	
	*/
	
	public void update(Job job) 
	{
		jobRepo.save(job);
	}
/*
	public void delete(Job job) throws RecordNotFoundException
	{
		jobRepo.findById(job.getCode())
				.orElseThrow(() -> new RecordNotFoundException("Job '" + job.getCode() + "'not found"));
		
	}
	
	*/
	public void delete(Job job) 
	{
		
		jobRepo.delete(job);
	}

	

	public void deleteByCode(String jobCode)
	{
			jobRepo.deleteById(jobCode);
		
	}

}
