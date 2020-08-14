package cst438_FinalProject.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import cst438_FinalProject.domain.Car;
import cst438_FinalProject.domain.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(HotelService.class)
public class HotelServiceTest {

  @MockBean
  private HotelService hotelService;

  @Autowired
  private MockMvc mvc;

  private JacksonTester<Hotel> jsonHotelAttempt;

  @BeforeEach
  public void setUpEach() {
    MockitoAnnotations.initMocks(this);
    JacksonTester.initFields(this, new ObjectMapper());
  }

  @Test
  public void testGetAllHotelReservations() throws Exception {
    Hotel hotel1 = new Hotel(1, "hotel", "01/01/2020", "01/02/2020", 2, 200);

    List<Hotel> hotels = new ArrayList<>();
    hotels.add(hotel1);

    given(hotelService.getAllHotelReservations()).willReturn(hotels);

    List<Hotel> hotelResult = hotelService.getAllHotelReservations();
    Hotel expectedResult = new Hotel(1, "hotel", "01/01/2020", "01"
            + "/02/2020"
        , 2, 200);

    assertThat(hotelResult.get(0)).isEqualTo(expectedResult);
  }

  @Test
  public void testFailGetAllHotelReservations() throws Exception {

    List<Hotel> hotels = new ArrayList<>();

    given(hotelService.getAllHotelReservations()).willReturn(hotels);

    List<Hotel> hotelResult = hotelService.getAllHotelReservations();

    assertThat(hotelResult.isEmpty()).isEqualTo(true);
  }

  @Test
  public void testGetAllHotelReservationsByEmailList() throws Exception {
    Hotel hotel1 = new Hotel(1, "hotel", "01/01/2020", "01/02/2020", 2, 200);

    List<Hotel> hotels = new ArrayList<>();
    hotels.add(hotel1);

    given(hotelService.getAllHotelReservationsByEmailList("TestEmail")).willReturn(hotels);

    List<Hotel> hotelResult = hotelService.getAllHotelReservationsByEmailList("TestEmail");
    Hotel expectedResult = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    assertThat(hotelResult.get(0)).isEqualTo(expectedResult);
  }

  @Test
  public void testFailGetAllHotelReservationsByEmailList() throws Exception {
    Hotel hotel1 = new Hotel(1, "hotel", "01/01/2020", "01/02/2020", 2, 200);

    List<Hotel> hotels = new ArrayList<>();
    hotels.add(hotel1);

    given(hotelService.getAllHotelReservationsByEmailList("TestEmail")).willReturn(hotels);

    List<Hotel> hotelResult = hotelService.getAllHotelReservationsByEmailList("TestEmail1");
    Hotel expectedResult = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    assertThat(hotelResult.isEmpty()).isEqualTo(true);
  }

  @Test
  public void testGetAllHotelReservationsByCustomerId() throws Exception {
    Hotel hotel1 = new Hotel(1, "hotel", "01/01/2020", "01/02/2020", 2, 200);

    List<Hotel> hotels = new ArrayList<>();
    hotels.add(hotel1);

    given(hotelService.getAllHotelReservationsByCustomerId(1)).willReturn(hotels);

    List<Hotel> hotelResult = hotelService.getAllHotelReservationsByCustomerId(1);
    Hotel expectedResult = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    assertThat(hotelResult.get(0)).isEqualTo(hotel1);
  }

  @Test
  public void testFailGetAllHotelReservationsByCustomerId() throws Exception {
    List<Hotel> hotels = new ArrayList<>();

    given(hotelService.getAllHotelReservationsByCustomerId(1)).willReturn(hotels);

    List<Hotel> hotelResult = hotelService.getAllHotelReservationsByCustomerId(1);
    Hotel expectedResult = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    assertThat(hotelResult.isEmpty()).isEqualTo(true);
  }

  @Test
  public void testGetHotelReservationByReservationId() throws Exception {
    Hotel hotel = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    given(hotelService.getHotelReservationByReservationId(1)).willReturn(hotel);

    Hotel hotelResult = hotelService.getHotelReservationByReservationId(1);
    Hotel expectedResult = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    assertThat(hotelResult).isEqualTo(expectedResult);
  }

  @Test
  public void testFailGetHotelReservationByReservationId() throws Exception {
    Hotel hotel = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    given(hotelService.getHotelReservationByReservationId(1)).willReturn(hotel);

    Hotel hotelResult = hotelService.getHotelReservationByReservationId(2);

    assertThat(hotelResult).isEqualTo(null);
  }

  @Test
  public void testCancelReservationByReservationId() throws Exception {
    Hotel hotel = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    given(hotelService.cancelReservationByReservationId(1)).willReturn(true);

    boolean hotelResult = hotelService.cancelReservationByReservationId(1);

    assertThat(hotelResult).isEqualTo(true);
  }

  @Test
  public void testFailCancelReservationByReservationId() throws Exception {
    Hotel hotel = new Hotel(1, "hotel", "01/01/2020", "01"
        + "/02/2020"
        , 2, 200);

    given(hotelService.cancelReservationByReservationId(1)).willReturn(true);

    boolean hotelResult = hotelService.cancelReservationByReservationId(2);

    assertThat(hotelResult).isEqualTo(false);
  }

  @Test
  public void testNewReservation() throws Exception {
    given(hotelService.newReservation(1, "fname", "lname", "email", "cim", "cid", "ciy", "com",
        "cod", "coy", "rt", 2)).willReturn(true);

    boolean hotelResult = hotelService.newReservation(1, "fname", "lname", "email", "cim", "cid", "ciy", "com",
        "cod", "coy", "rt", 2);

    assertThat(hotelResult).isEqualTo(true);
  }

  @Test
  public void testFailNewReservation() throws Exception {
    given(hotelService.newReservation(1, "fname", "lname", "email", "cim", "cid", "ciy", "com",
        "cod", "coy", "rt", 2)).willReturn(true);

    boolean hotelResult = hotelService.newReservation(2, "fname", "lname", "email", "cim", "cid",
        "ciy", "com",
        "cod", "coy", "rt", 2);

    assertThat(hotelResult).isEqualTo(false);
  }

}
