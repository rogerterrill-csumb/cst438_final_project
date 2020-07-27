package cst438_FinalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@GetMapping(value="/reservations/welcome")
	public String welcome() {
		return "Welcome";
	}
}
