package cst438_FinalProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NewReservationController {

	
	@GetMapping(value="/reservation/")
	public String reservation() {
		return "reservation";
	}

	
	
}
