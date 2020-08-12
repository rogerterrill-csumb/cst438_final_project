package cst438_FinalProject.service;

import cst438_FinalProject.domain.Hotel;
import cst438_FinalProject.repository.HotelRepository;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
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
    Iterator jsonIt = response.getBody().iterator();
    while (jsonIt.hasNext()) {
      System.out.println(jsonIt.next().equals("hotel"));
    }
    return true;
  }

  public String getAllHotelReservationsByEmail(String email) {
    String message = "";
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/customerEmail/" + email,
        JsonNode.class);

    JsonNode json = response.getBody();
    Iterator<JsonNode> iterableJson = json.iterator();
    while (iterableJson.hasNext()) {
      message += iterableJson.next().get("resID").asText() + ", ";
    }
    return message;

  }

  public List<Hotel> getAllHotelReservationsByEmailList(String email) {
    JsonNode current;

    List<Hotel> hotels = new ArrayList<>();
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/customerEmail/" + email,
        JsonNode.class);

    JsonNode json = response.getBody();
    Iterator<JsonNode> iterableJson = json.iterator();
    while (iterableJson.hasNext()) {
      current = iterableJson.next();

      hotels.add(new Hotel(current.get("resID").asInt(), current.get("hotelName").asText(),
          current.get("checkIn").asText(),
          current.get(
              "checkOut").asText(),
          current.get(
              "totalRooms").asInt(), current.get("totalPrice").floatValue()));
    }
    return hotels;
  }

  public void getAllHotelReservationsByCustomerId(int id) {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/customerID/" + id,
        JsonNode.class);
    JsonNode json = response.getBody();
    System.out.println(json);
  }

  public Hotel getHotelReservationByReservationId(int id) {
    ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/reservations/" + id,
        JsonNode.class);
    JsonNode json = response.getBody();
    System.out.println(json);
    return new Hotel(json.get("resID").asInt(), json.get("hotelName").asText(),
        json.get("checkIn").asText(),
        json.get(
            "checkOut").asText(),
        json.get(
            "totalRooms").asInt(), json.get("totalPrice").floatValue());
  }

  public void cancelReservationByReservationId(int id) {
    ResponseEntity<String> response = restTemplate.postForEntity(this.hotelBaseUrl
            + "/api/hotelReservation/cancelByReservationID/" + id, null,
        String.class);
    String message = response.getBody();
    System.out.println(message);
  }
}
