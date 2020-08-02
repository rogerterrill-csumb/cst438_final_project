package cst438_FinalProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import javax.validation.Valid;

import cst438_FinalProject.domain.*;

@Controller
public class NewReservationController {

	
	@GetMapping(value="/reservation/")
	public String reservation() {
		return "Reservation";
	}

	
	
}
