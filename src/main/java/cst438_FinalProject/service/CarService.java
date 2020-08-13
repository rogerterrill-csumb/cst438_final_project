package cst438_FinalProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import cst438_FinalProject.domain.*;


@Service
public class CarService {

  private static final Logger log = LoggerFactory.getLogger(CarService.class);

  private RestTemplate restTemplate;

  private String newCarReservationUrl;
  private String cancelCarReservationUrl;
  private String getCarReservations;

  public CarService(@Value("${car.url}") final String carUrl) {
    this.restTemplate = new RestTemplate();
    this.newCarReservationUrl = carUrl + "/api/reservation/new";
    this.cancelCarReservationUrl = carUrl +"/api/reservation/cancel";
    this.getCarReservations = carUrl + "/api/reservations";
  }


  // For Sending JSON as a Body.
  public boolean newCarReservation(Car car) {
    ObjectMapper oMapper = new ObjectMapper();
    Map<String, Object> map = oMapper.convertValue(car, Map.class);

    var headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

    ResponseEntity<String> response = restTemplate
        .postForEntity(this.newCarReservationUrl, entity, String.class);

    // check response
    if (response.getStatusCode() == HttpStatus.OK) {
      System.out.println("Request Successful");
      System.out.println(response.getBody());
      return true;
    } else {
      System.out.println("Request Failed");
      System.out.println(response.getStatusCode());
      return false;
    }
  }
    public boolean cancelCarReservation(String id) {
	  
	  var headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	  
	  Map<String,String> map = new HashMap<>();
	  map.put("reservationID",id);

	  HttpEntity<Map<String,String>> entity = new HttpEntity<>(map,headers);
	  ResponseEntity<String> response = restTemplate.postForEntity(this.cancelCarReservationUrl, entity, String.class);

	  if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
		  System.out.println("Car Cancel Successful");
		  return true;
	  } else {
		  System.out.println("Car Cancel Failed");
		  System.out.println(response.getStatusCode());
		  return false;
	  }
  }
    
    public String getReservationID(String email){
    	System.out.println("Reservation ID");
    	
    	String finalID ="";
    	ResponseEntity<List<CarResponse>> response = restTemplate.exchange(this.getCarReservations, HttpMethod.GET, null, new ParameterizedTypeReference<List<CarResponse>>() {});
    	
    	List<CarResponse> items = response.getBody();
    	System.out.println(items.toString());
    	
    	for (int i = 0; i < items.size()-1; i++) {
    		try {
        		String currentEmail = items.get(i).getEmail().toLowerCase();
        		if(currentEmail == null || currentEmail.isEmpty() ) {
        			continue;
        		}
        		if(currentEmail.toLowerCase().equals(email.toLowerCase())) {
        			finalID += items.get(i).getReservationID() +" ";
        		}
    		} catch (Exception e) {
    			System.out.println( e);
    		}

    	}
    	
    	return finalID;
  	    
    }
}
