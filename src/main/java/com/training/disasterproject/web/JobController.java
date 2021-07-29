package com.training.disasterproject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	//Adding new job form
	
	@RequestMapping("/add")
	public String showNewJobForm(Model model) {
		Job job = new Job();
		model.addAttribute("job", job);
		return "job_add";
		
	}
	
	//saving new record
	
	@RequestMapping(value="/save" , method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("job")Job job) {
		jobSvc.addJob(job);
		return "job_management";
	}
	
	
	//Update job form
	
	@RequestMapping(value="update/{code}")
	public ModelAndView showUpdateJobForm(@PathVariable("code") String code) {
		ModelAndView mav = new ModelAndView("update_job");
		Job job = jobSvc.findJobByCode(code);
		mav.addObject("job",job);
		return mav;
	}
	//delete job 
	@RequestMapping(value="/delete/{code}")
	public String deleteJob(@PathVariable("code") String code) {
		jobSvc.deleteByCode(code);
		return "job_management";
		
	}

}
