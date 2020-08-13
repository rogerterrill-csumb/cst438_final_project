package cst438_FinalProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

  public CarService(@Value("${car.url}") final String carUrl) {
    this.restTemplate = new RestTemplate();
    this.newCarReservationUrl = carUrl + "/api/reservation/new";
    this.cancelCarReservationUrl = carUrl +"/api/reservation/cancel";
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
}
