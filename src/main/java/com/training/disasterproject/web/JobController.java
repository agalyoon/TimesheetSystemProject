package com.training.disasterproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.disasterproject.model.Job;
import com.training.disasterproject.model.Machine;
import com.training.disasterproject.service.JobServiceImpl;
import com.training.disasterproject.service.MachineServiceImpl;
import com.training.disasterproject.service.UserServiceImpl;

@Controller
@RequestMapping("/jobs")
public class JobController {
	@Autowired
	JobServiceImpl jobSvc;

	

	@Autowired
	UserServiceImpl userSvc;
	@GetMapping
	public String showAllJobs(Model model)
	{
		model.addAttribute("job", jobSvc.getAllJobs());
		return "job_management";
	}
	
	@RequestMapping("/add")
	public String showNewJobForm(Model model) {
		Job job = new Job();
		model.addAttribute("job", job);
		return "job_add";
		
	}
	
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("job")Job job) {
		jobSvc.addJob(job);
		return "job_management";
	}
	

}
