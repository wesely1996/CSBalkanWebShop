package com.csbalkan.webshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csbalkan.webshop.dto.UserDTO;
import com.csbalkan.webshop.srvicies.UserIdentificationService;

@Controller
@RequestMapping("/user")
public class UserIdentificationController {
	
	@Autowired
	UserIdentificationService uis;
	
	@GetMapping("/register")
	public String openRegistrationPage() {
		return "register";
	}
	
	@PostMapping("/registerNewUser")
	public String registerNewUser(@ModelAttribute("user") UserDTO newUser, Model m) {
		Integer result = uis.createNewUser(newUser);
		if(result == 1) {
			m.addAttribute("errorMessage", "Username is already in use. Please try with a different one.");
			return "register";
		}
		if(result == -1) {
			m.addAttribute("errorMessage", "Could not create user, please try again.");
			return "register";
		}
		return "index";
	}
	
	@PostMapping("/logIn")
	public String logIn(@ModelAttribute("user") UserDTO user, Model m) {
		int result = uis.logIn(user);
		if(result == -2) {
			m.addAttribute("errorMessage", "User doesn't exist.");
			return "index";
		}
		if(result == -1) {
			m.addAttribute("errorMessage", "Passowrd isn't correct.");
			return "index";
		}
		return "productsPage";
	}
}
