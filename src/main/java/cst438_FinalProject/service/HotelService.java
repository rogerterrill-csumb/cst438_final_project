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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpStatusCodeException;
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

  public List<Hotel> getAllHotelReservations() {
    JsonNode current;

    List<Hotel> hotels = new ArrayList<>();

    try {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
              + "/api/hotelReservation/getAllReservations",
          JsonNode.class);
      JsonNode json = response.getBody();
      Iterator<JsonNode> iterableJson = json.iterator();
      while (iterableJson.hasNext()) {
        current = iterableJson.next();

        hotels.add(new Hotel(
            current.get("resID").asInt(),
            current.get("hotelName").asText(),
            current.get("checkIn").asText(),
            current.get("checkOut").asText(),
            current.get("totalRooms").asInt(),
            current.get("totalPrice").floatValue()));
      }
    } catch (HttpStatusCodeException ex) {
      System.out.println("Get By Email Failed");
      System.out.println(ex.getStatusCode());
      hotels.add(new Hotel(0, "-", "-", "-", 0, 0));
    }
    return hotels;
  }

  public List<Hotel> getAllHotelReservationsByEmailList(String email) {
    JsonNode current;

    List<Hotel> hotels = new ArrayList<>();
    try {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
              + "/api/hotelReservation/customerEmail/" + email,
          JsonNode.class);
      JsonNode json = response.getBody();
      Iterator<JsonNode> iterableJson = json.iterator();
      while (iterableJson.hasNext()) {
        current = iterableJson.next();

        hotels.add(new Hotel(
            current.get("resID").asInt(),
            current.get("hotelName").asText(),
            current.get("checkIn").asText(),
            current.get("checkOut").asText(),
            current.get("totalRooms").asInt(),
            current.get("totalPrice").floatValue()));
      }
    } catch (HttpStatusCodeException ex) {
      System.out.println("Get By Email Failed");
      System.out.println(ex.getStatusCode());
      hotels.add(new Hotel(0, "-", "-", "-", 0, 0));
      return null;
    }
    return hotels;
  }

  public List<Hotel> getAllHotelReservationsByCustomerId(int id) {
    JsonNode current;

    List<Hotel> hotels = new ArrayList<>();
    try {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
              + "/api/hotelReservation/customerID/" + id,
          JsonNode.class);
      JsonNode json = response.getBody();
      Iterator<JsonNode> iterableJson = json.iterator();
      while (iterableJson.hasNext()) {
        current = iterableJson.next();

        hotels.add(new Hotel(
            current.get("resID").asInt(),
            current.get("hotelName").asText(),
            current.get("checkIn").asText(),
            current.get("checkOut").asText(),
            current.get("totalRooms").asInt(),
            current.get("totalPrice").floatValue()));
      }
    } catch (HttpStatusCodeException ex) {
      System.out.println("Get By Email Failed");
      System.out.println(ex.getStatusCode());
      hotels.add(new Hotel(0, "-", "-", "-", 0, 0));
      return null;
    }
    return hotels;
  }

  public Hotel getHotelReservationByReservationId(int id) {
    try {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(this.hotelBaseUrl
              + "/api/hotelReservation/reservations/" + id,
          JsonNode.class);
      JsonNode json = response.getBody();
      System.out.println(json);
      return new Hotel(
          json.get("resID").asInt(),
          json.get("hotelName").asText(),
          json.get("checkIn").asText(),
          json.get("checkOut").asText(),
          json.get("totalRooms").asInt(),
          json.get("totalPrice").floatValue()
      );
    } catch (HttpStatusCodeException ex) {
      System.out.println(ex.getStatusCode());
      return new Hotel(0, "N/A", "N/A", "N/A", 0, 0);
    }
  }

  public boolean cancelReservationByReservationId(int id) {
    try {
      ResponseEntity<String> response = restTemplate.postForEntity(this.hotelBaseUrl
              + "/api/hotelReservation/cancelByReservationID/" + id, null,
          String.class);
      String message = response.getBody();
      System.out.println(message);
      return true;
    } catch (HttpStatusCodeException ex) {
      System.out.println(this.hotelBaseUrl + "/api/hotelReservation/cancelByReservationID/" + id);
      System.out.println(ex.getStatusCode());
      return false;
    }
  }

  public boolean newReservation(
      int hotelid,
      String fname,
      String lname,
      String email,
      String checkinmonth,
      String checkinday,
      String checkinyear,
      String checkoutmonth,
      String checkoutday,
      String checkoutyear,
      String roomtype,
      int numrooms) {
    try {
      ResponseEntity<String> response = restTemplate.getForEntity(
          this.hotelBaseUrl + "/api/hotelReservation/createReservation/" + hotelid + "/" + fname +
              "/" + lname + "/" + email + "/"
              + checkinmonth + "/" + checkinday + "/" + checkinyear + "/" + checkoutmonth + "/"
              + checkoutday + "/" + checkoutyear + "/" + roomtype + "/" + numrooms, String.class);
    } catch (HttpStatusCodeException ex) {
      System.out.println("New Reservation Failed");
      System.out.println(ex.getStatusCode());
      System.out.println(
          this.hotelBaseUrl + "/api/hotelReservation/createReservation/" + hotelid + "/" + fname +
              "/" + lname + "/" + email + "/"
              + checkinmonth + "/" + checkinday + "/" + checkinyear + "/" + checkoutmonth + "/"
              + checkoutday + "/" + checkoutyear + "/" + roomtype + "/" + numrooms);
      return false;
    }
    return true;
  }
}
