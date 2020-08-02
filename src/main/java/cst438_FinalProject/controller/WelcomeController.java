package cst438_FinalProject.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import cst438_FinalProject.domain.LoginUser;

@Controller
public class WelcomeController {
	@GetMapping(value="/welcome")
	public String welcome(
			@ModelAttribute("loginUser") LoginUser loginUser
			) {
		
		//Checking if the Login User was passed Correctly
		System.out.println(loginUser.toString());
		return "Welcome";
	}
}
