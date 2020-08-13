package cst438_FinalProject.service;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import cst438_FinalProject.domain.*;

@Service
public class FlightService {
	
	private static final Logger log = LoggerFactory.getLogger(FlightService.class);
	private RestTemplate restTemplate;
	private String flightUrl;
	
	public FlightService( @Value("${flight.url}") final String flightUrl) {
		this.restTemplate = new RestTemplate();
		this.flightUrl = flightUrl;
	}
	
  public void newFlightReservation(
	      int flightID,
	      String email,
	      String seatClass,
	      int numPassengers) {
	    try {
	      ResponseEntity<String> response = restTemplate.getForEntity(
	          this.flightUrl + "/api/flight/reservation2/" + email + "/" + seatClass +
	              "/" + numPassengers + "/false/" + flightID, String.class);
	    } catch (HttpStatusCodeException ex) {
	      System.out.println("New Reservation Failed");
	      System.out.println(ex.getStatusCode());
	      System.out.println(this.flightUrl + "/api/flight/reservation2/" + email + "/" + seatClass +
	              "/" + numPassengers + "/false/" + flightID);
	    }
	  }
}
