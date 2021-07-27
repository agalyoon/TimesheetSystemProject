package com.training.disasterproject.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.training.disasterproject.model.Timecard;
import com.training.disasterproject.model.User;
import com.training.disasterproject.repository.TimecardRepository;
import com.training.disasterproject.repository.UserRepository;
import com.training.disasterproject.web.dto.SubmitTimecardDto;
import com.training.disasterproject.web.dto.UserRegistrationDto;

@Controller
public class MainController {
	@Autowired
	private TimecardRepository timecardRepository;

	@GetMapping("/")
	public RedirectView root() {
		RedirectView url = new RedirectView("/login");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null)
			return url;

		boolean isContractor = authentication.getAuthorities().stream()
				.anyMatch(r -> r.getAuthority().equals("ROLE_CONTRACTOR"));
		boolean isAdmin = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));

		if (isContractor)
			url.setUrl("/submit_timecard");
		if (isAdmin)
			url.setUrl("/manage_timecard");

		return url;
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}

	@GetMapping("submit_timecard")
	public String submitTimecardGet() {
		return "submit_timecard";
	}

    @ModelAttribute("timecard")
    public SubmitTimecardDto tcDto() {
        return new SubmitTimecardDto();
    }

	@PostMapping("submit_timecard")
	public String submitTimecardPost(@ModelAttribute("timecard") @Valid SubmitTimecardDto tcDto, BindingResult result) {

		if (result.hasErrors()) {
			return "submit_timecard";
		}

		Timecard tc = new Timecard();
		tc.setName(tcDto.getContractorname());
		tc.setSitecode(tcDto.getSitecode());
		tc.setWorkedhrs(tcDto.getHrsworked());
		tc.setLabortotal(tcDto.getLabortotal());
		tc.setMachinecode(tcDto.getMachinecode());
		tc.setUsedhrs(tcDto.getHrsused());
		tc.setMachinetotal(tcDto.getMachinetotal());
		tc.setDate(tcDto.getDate());

		timecardRepository.save(tc);
		return "redirect:/submit_timecard?success";
	}

	@GetMapping("/manage_timecard")
	public String manageTimecards(Model model) {
		model.addAttribute("timecards", timecardRepository.findAll());
		return "manage_timecard";
	}

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/view_timecard")
	public String viewTimecards(Model model) {
		User user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("timecards",
				timecardRepository.findAllByName(user.getFirstName() + " " + user.getLastName()));
		return "view_timecard";
	}

	@GetMapping("approve/{timecardid}")
	public String approveTimecard(@PathVariable Long timecardid) {
		Timecard tc = timecardRepository.getById(timecardid);
		tc.setStatus("Finalized");
		timecardRepository.saveAndFlush(tc);
		return "redirect:/manage_timecard";
	}

	public String viewTimecard() {

		return "user/index";
	}

}
