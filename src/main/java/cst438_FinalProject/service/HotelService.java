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
public class HotelService {
	private static final Logger log = LoggerFactory.getLogger(HotelService.class);
	
	private RestTemplate restTemplate;
	
	private String hotelUrl;
	
	public HotelService( @Value("${hotel.url}") final String hotelUrl) {
		this.restTemplate = new RestTemplate();
		this.hotelUrl = hotelUrl;
	}
	
	// Change to Hotel Class Object
	public Hotel hotelInfo(String firstName, String lastName, String email) {
		ResponseEntity<JsonNode> response = 
              restTemplate.getForEntity(
				hotelUrl + "?firstName=" + firstName + "&lastName=" + lastName
                   +"&email=" + email,
				JsonNode.class);
		JsonNode json = response.getBody();    // 2
		
		log.info("Status code from weather server:" +
                  response.getStatusCodeValue());
		
		//Parse out the elements from the JSON object
		
		return new Hotel(); // insert the elements from Hotel and return the object.
	}
}
