package com.training.disasterproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.disasterproject.exception.RecordExistsException;
import com.training.disasterproject.exception.RecordNotFoundException;
import com.training.disasterproject.model.Machine;
import com.training.disasterproject.model.Site;
import com.training.disasterproject.model.User;
import com.training.disasterproject.repository.MachineRepository;


@Service
public class MachineServiceImpl implements MachineService{
	@Autowired
	private MachineRepository machineRepo;

	public List<Machine> getAllByMachine(Site site, User user)
	{
		return machineRepo.findAllBySiteAndMachine(site, user);
	}

	
	public void update(Machine entry) 
	{
		
		machineRepo.save(entry);
	}

	public void delete(Machine entry)
	{
		machineRepo.delete(entry);
	}

	public void delete(String id) 
	{
		
		machineRepo.deleteById(id);
	}

	public List<Machine> getAllMachine()
	{
		return (List<Machine>) machineRepo.findAll();
	}

	public Optional<Machine> get(String code)
	{
		return machineRepo.findById(code);
	}

	@Autowired
	private MachineRepository machineRepo;

	public List<Machine> getAllByMachine(Site site, User user)
	{
		return machineRepo.findAllBySiteAndMachine(site, user);
	}

	public void add(Machine entry) throws RecordExistsException
	{
		if (entry.getCode() != null)
		{
			Optional<Machine> job = machineRepo.findById(entry.getCode());
			if (job.isPresent())
			{
				throw new RecordExistsException("Machine with '" + entry.getCode() + "' exists");
			}
		}
		machineRepo.save(entry);
	}

	public void update(Machine entry) throws RecordNotFoundException
	{
		if (entry.getCode() == null)
		{
			throw new IllegalArgumentException("Machine id must be present");
		}
		
		Optional<Machine> optMac = machineRepo.findById(entry.getCode());
		if (optMac.isEmpty())
		{
			throw new RecordNotFoundException("Machine id " + entry.getCode() + "not found");
		}
		machineRepo.save(entry);
	}

	public void delete(Machine entry)
	{
		machineRepo.delete(entry);
	}

	public void delete(String code) throws RecordNotFoundException
	{
		Machine entry = machineRepo.findById(code)
				.orElseThrow(() -> new RecordNotFoundException("Machine code '" + code + "' not found"));
		machineRepo.delete(entry);
	}

	public List<Machine> getAllMachine()
	{
		return (List<Machine>) machineRepo.findAll();
	}

	public Optional<Machine> get(String code)
	{
		return machineRepo.findById(code);
	}

	
}
