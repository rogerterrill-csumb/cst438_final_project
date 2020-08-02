package cst438_FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import cst438_FinalProject.domain.*;

@Controller
public class UserLoginController {

	
	@GetMapping(value="/login")
	public String welcome(Model model) {
		
		LoginUser loginUser = new LoginUser();
		
		model.addAttribute("loginUser",loginUser);
		
		return "login_form";
	}
	
	@PostMapping(value="/login")
	public String login(@ModelAttribute("loginUser") @Valid LoginUser loginUser,
			RedirectAttributes redirectAttrs,
		BindingResult result,
		Model model){
		if(result.hasErrors()) {
			return "login";
		}
		
		//Pass the Login user to the next page
		redirectAttrs.addFlashAttribute("loginUser", loginUser);
		
		return "redirect:welcome";
			
	}
}
