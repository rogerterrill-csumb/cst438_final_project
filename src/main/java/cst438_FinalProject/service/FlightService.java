package cst438_FinalProject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import cst438_FinalProject.domain.*;

@Service
public class FlightService {
	private static final Logger log = LoggerFactory.getLogger(FlightService.class);
	
	private RestTemplate restTemplate;
	
	private String flightUrl;
	
	public FlightService( @Value("${FLIGHT.URL}") final String flightUrl) {
		this.restTemplate = new RestTemplate();
		this.flightUrl = flightUrl;
	}
	
	// Change to Flight Class Object
	public Flight flightInfo(String firstName, String lastName, String email) {
		ResponseEntity<JsonNode> response = 
              restTemplate.getForEntity(
				flightUrl + "?fName=" + firstName + "&lastName=" + lastName
                   +"&email=" + email,
				JsonNode.class);
		JsonNode json = response.getBody();    // 2
		
		log.info("Status code from weather server:" +
                  response.getStatusCodeValue());
		
		//Parse out the elements from the JSON object
		
		return new Flight(); // insert the elements from Flight and return the object.
	}
}
