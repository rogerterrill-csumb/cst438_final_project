package cst438_FinalProject.controller;

import cst438_FinalProject.repository.HotelRepository;
import cst438_FinalProject.repository.UserRepository;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cst438_FinalProject.domain.*;
import cst438_FinalProject.service.*;
import cst438_FinalProject.repository.*;
import org.springframework.web.bind.annotation.RequestParam;

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
  FlightService flightService;

  @Autowired
  UserRepository userRepository;

  @Autowired
  HotelRepository hotelRepository;

  @GetMapping(value = "/welcome")
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
    model.addAttribute("msg", msg);

    Iterable<Hotel> hotels = hotelService.getAllHotelReservationsByEmailList(user.getEmail());
    model.addAttribute("hotels", hotels);

    return "welcome";
  }

  @PostMapping(value = "/new/car")
  public String createCarReservation(
      @ModelAttribute("car") Car car,
      Model model) {

    car.setEmail(user.getEmail());

    System.out.println("CAR OBJECT: " + car.toString());
    boolean testCar;
    try {
      testCar = carService.newCarReservation(car);

    } catch (Exception e) {
      System.out.println("W3AController : createUser exception. " + e.getMessage());
      model.addAttribute("message", e.getMessage());
      System.out.println(e.getMessage());
      return "error";
    }

    if (testCar) {
      System.out.println("SUCCESS CAR");

    } else {
      System.out.println("FAIL CAR");
    }

    return "welcome";
  }

  @PostMapping(value = "/hotel/new")
  public String createHotelReservation(
      @RequestParam("hotelid") int hotelid,
      @RequestParam("checkinmonth") String checkinmonth,
      @RequestParam("checkinday") String checkinday,
      @RequestParam("checkinyear") String checkinyear,
      @RequestParam("checkoutmonth") String checkoutmonth,
      @RequestParam("checkoutday") String checkoutday,
      @RequestParam("checkoutyear") String checkoutyear,
      @RequestParam("roomtype") String roomtype,
      @RequestParam("numrooms") int numrooms,
      Model model) {

    hotelService.newReservation(hotelid, user.getFname(), user.getLname(), user.getEmail(), checkinmonth,
        checkinday,
        checkinyear, checkoutmonth, checkoutday, checkoutyear, roomtype, numrooms);

    System.out.println(user.getEmail());

    return "welcome";
  }

  @PostMapping(value = "/hotel/cancel")
  public String deleteHotelReservation(@RequestParam("id") int id, Model model) {
    hotelService.cancelReservationByReservationId(id);
    return "welcome";
  }

  @PostMapping(value = "/hotel/detail")
  public String getHotelReservationInfo(@RequestParam("id") int id, Model model) {
    Hotel hotel = hotelService.getHotelReservationByReservationId(id);
    model.addAttribute("hotelDetails", hotel);
    return "hotel_reservation_details";
  }
	@PostMapping(value="/cancel/car")
		public String createCarReservation(
				@ModelAttribute("carId") String carId,
				Model model) {
			boolean status;
			try {
				status = carService.cancelCarReservation(carId);
			} catch (Exception e) {
				System.out.println("CancelCar Exception. " + e.getMessage());
				model.addAttribute("message", e.getMessage());
				System.out.println(e.getMessage());
				status = false;
			}
			if(status) {
				System.out.println("New Car Reservation Created");
				model.addAttribute("carMessage", "Cancelled Car Reservation");
			
			} else {
				System.out.println("Failed to Cancel Car Reservation");
				model.addAttribute("carMessage", "Failed to Cancel Car Reservation");
			}

			return "welcome";
		}

	@GetMapping(value="/details/car")
	public String getCarDetails(
	Model model) {
		String awesome = carService.getReservationID(user.getEmail());
		System.out.println("Found records");
		System.out.println(awesome);
		model.addAttribute("carID","Found Reservation ID: " + awesome);
		return "welcome";
	}
	
	@PostMapping(value = "/flight/new")
	public String createFlightReservation(
    @RequestParam("flightID") int flightID,
    @RequestParam("seatClass") String seatClass,
    @RequestParam("numPassengers") int numPassengers,
    Model model) {

	flightService.newFlightReservation(flightID, user.getEmail(), seatClass, numPassengers);

	System.out.println(user.getEmail());

	return "welcome";

	}
}
