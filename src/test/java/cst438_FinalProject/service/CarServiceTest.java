package cst438_FinalProject.service;

import cst438_FinalProject.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
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

@SpringBootTest
public class CarServiceTest {

  @MockBean
  private CarService carService;

  // This method is executed before each test
  @BeforeEach
  public void setUpEach() {
    MockitoAnnotations.initMocks( this);

  }

  @Test
  public void testCarFound() throws Exception {
    Car car = new Car("test@test.com", "RandomCity", "08/12/2020", "NextCity", "08/13/2020", "SUV");

    given(carService.newCarReservation(car)).willReturn(true);

    boolean result = carService.newCarReservation(car);
    boolean expectedResult = true;

    assertThat(expectedResult).isEqualTo(result);
  }
  
  @Test
  public void testFailCarFound() throws Exception {
	    Car car = new Car(
	    	"test@test.com",
	    	"nada",
	    	"08/20/2020",
	    	"noLocation",
	    	"08/21/2020",
	    	null
	    );

	    given(carService.newCarReservation(car)).willReturn(true);

	    boolean carResult=  carService.newCarReservation(car);
	    boolean expectedResult = false;

	    assertThat(expectedResult).isEqualTo(carResult);
	  }
	  
  
  @Test
  public void testFailCancelReservation() throws Exception{
	  boolean expectedResult = false;
	  given(carService.cancelCarReservation("99")).willReturn(false);
	  
	  boolean carResult = carService.cancelCarReservation("99");
	  
	  assertThat(expectedResult).isEqualTo(carResult);
  }
  
  @Test
  public void getCarReservations() throws Exception{
	  String expectedResult = "70 ";
	  given(carService.getReservationID("michael9j2lee@gmail.com")).willReturn("70 ");
	  
	  String reservationResult = carService.getReservationID("michael9j2lee@gmail.com");
	  
	  assertThat(expectedResult).isEqualTo(reservationResult);	  
  }
  
  @Test
  public void failGetCarReservations() throws Exception{
	  String expectedResult = "72 ";
	  given(carService.getReservationID("michael9j2lee@gmail.com")).willReturn("70 ");
	  
	  String reservationResult = carService.getReservationID("michael9j2lee@gmail.com");
	  
	  assertThat(expectedResult).isEqualTo(reservationResult);	  
  }
  
  
}
