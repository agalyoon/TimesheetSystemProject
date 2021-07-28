package com.training.disasterproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.disasterproject.exception.RecordExistsException;
import com.training.disasterproject.model.Site;
import com.training.disasterproject.repository.SiteRepository;

@Service
public class SiteServiceImpl
{
	@Autowired
	private SiteRepository siteRepo;

	public Optional<Site> get(String code)
	{
		return siteRepo.findById(code);
	}

	public Iterable<Site> getAll()
	{
		return siteRepo.findAll();
	}

	public void add(Site entry) throws RecordExistsException
	{
		if (entry.getCode() != null)
		{
			Optional<Site> site = siteRepo.findById(entry.getCode());
			if (site.isPresent())
			{
				throw new RecordExistsException("Site with '" + entry.getCode() + "' exists");
			}
		}
		siteRepo.save(entry);
	}

	public void update(Site entry)
	{
		if (entry.getCode() == null)
		{
			throw new IllegalArgumentException("Site id must be present");
		}
		siteRepo.save(entry);
	}

	public void delete(String entry)
	{
		siteRepo.deleteById(entry);
	}

	public List<Site> getAllSites()
	{
		return (List<Site>) siteRepo.findAll();
	}

	
}
