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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.disasterproject.exception.RecordExistsException;
import com.training.disasterproject.exception.RecordNotFoundException;
import com.training.disasterproject.model.Job;
import com.training.disasterproject.model.Machine;
import com.training.disasterproject.model.Site;
import com.training.disasterproject.model.Timecard;
import com.training.disasterproject.model.User;
import com.training.disasterproject.service.MachineServiceImpl;
import com.training.disasterproject.service.UserServiceImpl;
import com.training.disasterproject.web.dto.SubmitTimecardDto;

@Controller
@RequestMapping("/machines")
public class MachineController {
	@Autowired
	MachineServiceImpl machineSvc;

	@Autowired
	UserServiceImpl userSvc;

	@GetMapping
	public String showAllMachines(Model model) {
		List<Machine> machines = machineSvc.getAllMachine();
		model.addAttribute("machines", machines);
		return "machine_management";
	}

	@RequestMapping("/add")
	public String showNewMachineForm(Model model) {
		Machine machine = new Machine();
		model.addAttribute("machine", machine);
		return "machine_add";

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveMachine(@ModelAttribute("machine") Machine machine) {
		machineSvc.addMachine(machine);
		return "redirect:/machines";
	}


	// Update machine form

	@RequestMapping(value = "update/{code}")
	public ModelAndView showUpdateJobForm(@PathVariable("code") String code) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("machine_update.html");
		Machine machine = machineSvc.findMachineByCode(code);
		mav.addObject("machine", machine);
		return mav;
	}

	// delete job
	@RequestMapping(value = "/delete/{code}")
	public String deleteJob(@PathVariable("code") String code) {
		machineSvc.deleteByCode(code);
		return "redirect:/machines";

	}

}
