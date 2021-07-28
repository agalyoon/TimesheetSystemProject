package com.training.disasterproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
