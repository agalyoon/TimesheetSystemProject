package com.training.disasterproject.web;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.disasterproject.exception.RecordExistsException;
import com.training.disasterproject.exception.RecordNotFoundException;
import com.training.disasterproject.model.Machine;
import com.training.disasterproject.model.Site;
import com.training.disasterproject.model.User;
import com.training.disasterproject.service.MachineServiceImpl;
import com.training.disasterproject.service.SiteServiceImpl;
import com.training.disasterproject.service.UserServiceImpl;



@Controller
@RequestMapping("/machines")
public class MachineController
{
	@Autowired
	MachineServiceImpl machineSvc;

	@Autowired
	SiteServiceImpl siteSvc;

	@Autowired
	UserServiceImpl userSvc;

	@GetMapping
	public String showAllMachines(Model model)
	{
		model.addAttribute("machines", machineSvc.getAllMachine());
		return "machine_management";
	}

	
}
