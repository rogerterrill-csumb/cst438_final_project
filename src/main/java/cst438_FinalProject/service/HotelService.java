package cst438_FinalProject.service;

import cst438_FinalProject.domain.Hotel;
import cst438_FinalProject.repository.HotelRepository;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class HotelService {

  @Autowired
  HotelRepository hotelRepository;

  private static final Logger log = LoggerFactory.getLogger(HotelService.class);
  private RestTemplate restTemplate;
  private String hotelBaseUrl;

  // Constructor
  public HotelService(@Value("${hotel.url}") final String hotelBaseUrl) {
    this.restTemplate = new RestTemplate();
    this.hotelBaseUrl = hotelBaseUrl;
  }

  public boolean getAllHotelReservations() {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/getAllReservations",
        JsonNode.class);
    JsonNode json = response.getBody();
    log.info("Status code form hotel reservation server: " + response.getStatusCodeValue());
    System.out.println(response);
    return true;
  }

  public String getAllHotelReservationsByEmail(String email) {
    String hotelName, checkIn, checkOut;
    float totalRooms, totalPrice;
    JsonNode current;

    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/customerEmail/" + email,
        JsonNode.class);
    JsonNode json = response.getBody();
    Iterator<JsonNode> iterableJson = json.iterator();
    while(iterableJson.hasNext()) {
      current = iterableJson.next();
      hotelName = current.get("hotelName").asText();
      checkIn = current.get("checkIn").asText();
      checkOut = current.get("checkOut").asText();
      totalRooms = (float) current.get("totalRooms").asDouble();
      totalPrice = (float) current.get("totalPrice").asDouble();
      hotelRepository.save(new Hotel(hotelName, checkIn, checkOut, totalRooms, totalPrice));
    }
    return "Done";
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
