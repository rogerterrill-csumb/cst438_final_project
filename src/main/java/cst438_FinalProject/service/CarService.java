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
public class CarService {
	private static final Logger log = LoggerFactory.getLogger(CarService.class);
	
	private RestTemplate restTemplate;
	
	private String carUrl;
	
	public CarService( @Value("/carService") final String carUrl) {
		this.restTemplate = new RestTemplate();
		this.carUrl = carUrl;
	}
	
	// Change to Car Class Object
	public Car carInfo(String firstName, String lastName, String email) {
		ResponseEntity<JsonNode> response = 
              restTemplate.getForEntity(
				carUrl + "?firstName=" + firstName + "&lastName=" + lastName
                   +"&email=" + email,
				JsonNode.class);
		JsonNode json = response.getBody();    // 2
		
		log.info("Status code from weather server:" +
                  response.getStatusCodeValue());
		
		//Parse out the elements from the JSON object
		
		return new Car(); // insert the elements from Car and return the object.
	}
}
