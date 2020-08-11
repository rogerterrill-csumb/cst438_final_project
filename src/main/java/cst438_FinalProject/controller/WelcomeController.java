package cst438_FinalProject.controller;

import cst438_FinalProject.repository.HotelRepository;
import cst438_FinalProject.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cst438_FinalProject.domain.*;
import cst438_FinalProject.service.*;

@Controller
public class WelcomeController {
	
	private static User user;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CarService carService;

	@Autowired
	HotelService hotelService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	HotelRepository hotelRepository;
	
	@GetMapping(value="/welcome")
	public String welcome(
			@ModelAttribute("loginUser") LoginUser loginUser,
			Model model) {
		
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


//		model.addAttribute("hotels", hotels);
		
		return "welcome";
	}

	@PostMapping(value="/new/car")
	public String createCarReservation(
			@ModelAttribute("car") Car car,
			Model model) {
			
			car.setEmail(user.getEmail());
			
			System.out.println("CAR OBJECT: " + car.toString());
			boolean testCar;
			try {
				 testCar = carService.newCarReservation(car);
			 
			} catch (Exception e) {
				System.out.println("W3AController : createUser exception. "+e.getMessage());
				model.addAttribute("message", e.getMessage());
				System.out.println(e.getMessage());
				return "error";
			}
			
			
			if(testCar) {
				System.out.println("SUCCESS CAR");
			
			} else {
				System.out.println("FAIL CAR");
			}
	
				return "welcome";
	}

	@PostMapping(value="/new/hotel")
	public String createHotelReservation(Model model) {

		System.out.println(user.getEmail());
		System.out.println(hotelService.getAllHotelReservationsByEmail(user.getEmail()));

		return "welcome";
	}
	
	
}
