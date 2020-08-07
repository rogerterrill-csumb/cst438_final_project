package cst438_FinalProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import cst438_FinalProject.domain.*;
import cst438_FinalProject.service.*;

import cst438_FinalProject.domain.LoginUser;

@Controller
public class WelcomeController {
	

	@Autowired
	UserService userService;
	
	@GetMapping(value="/welcome")
	public String welcome(
			@ModelAttribute("loginUser") LoginUser loginUser,
			Model model) {
		
		User user;
		
		//Checking if the Login User was passed Correctly
		System.out.println(loginUser.toString());
		
		user = userService.getUser(loginUser);
		System.out.println(user.toString());
		
		String msg;
		
		if (userService.existUser()) {
			msg = "Found User information for " + loginUser.getFname() + " " + loginUser.getLname();
		} else {
			msg = "Creating account for " + loginUser.getFname() + " " + loginUser.getLname();
		}
		model.addAttribute("msg",msg);
		
		
		return "Welcome";
	}
}
