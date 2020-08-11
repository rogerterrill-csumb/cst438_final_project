package cst438_FinalProject.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import cst438_FinalProject.domain.*;

@Service
public class HotelService {

  private static final Logger log = LoggerFactory.getLogger(HotelService.class);
  private RestTemplate restTemplate;
  private String hotelBaseUrl;

  // Constructor
  public HotelService(@Value("${hotel.url}") final String hotelBaseUrl) {
    this.restTemplate = new RestTemplate();
    this.hotelBaseUrl = hotelBaseUrl;
  }

  public void getAllHotelReservations() {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/getAllReservations",
        JsonNode.class);
    JsonNode json = response.getBody();
    log.info("Status code form hotel reservation server: " + response.getStatusCodeValue());
    System.out.println(response);
  }

  public void getAllHotelReservationsByEmail(String email) {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/customerEmail/" + email,
        JsonNode.class);
    JsonNode json = response.getBody();
    System.out.println(json);
  }

  public void getAllHotelReservationsByCustomerId(int id) {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/customerID/" + id,
        JsonNode.class);
    JsonNode json = response.getBody();
    System.out.println(json);
  }

  public void getHotelReservationByReservationId(int id) {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/reservations/" + id,
        JsonNode.class);
    JsonNode json = response.getBody();
    System.out.println(json);
  }

  public void cancelReservationByReservationId(int id) {
    ResponseEntity<String> response = restTemplate.postForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/cancelByReservationID/" + id, null,
        String.class);
    String message = response.getBody();
    System.out.println(message);
  }
}
