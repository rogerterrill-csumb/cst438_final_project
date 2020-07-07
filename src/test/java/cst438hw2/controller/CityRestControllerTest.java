package cst438hw2.controller;

import static org.assertj.core.api.Assertions.assertThat;

import cst438hw2.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cst438hw2.domain.*;
import cst438hw2.service.WeatherService;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

// class must be annotated as WebMvcTest,  not SpringBootTest
@WebMvcTest(CityRestController.class)
public class CityRestControllerTest {

  // declare as @MockBean those classes which will be stubbed in the test
  // These classes must be Spring components (such as Repositories)
  // or @Service classes.

  @MockBean
  private WeatherService weatherService;

  @MockBean
  private CityRepository cityRepository;

  @MockBean
  private CityService cityService;

  // This class is used for make simulated HTTP requests to the class
  // being tested.
  @Autowired
  private MockMvc mvc;

  // These objects will be magically initialized by the initFields method below.
  private JacksonTester<CityInfo> jsonCityAttempt;

  // This method is executed before each Test.
  @BeforeEach
  public void setUpEach() {
    MockitoAnnotations.initMocks(this);
    JacksonTester.initFields(this, new ObjectMapper());
  }

  // Have one or more test methods.
  @Test
  public void cityFound() throws Exception {

    Country country = new Country("USA", "United States");
    City city = new City(1, "TestCity", "DistrictTest", 123456, country);
    List<City> cities = new ArrayList<City>();
    TempAndTime testTemp = new TempAndTime(309.93, 1593566001, -14400);
    cities.add(city);

    given(cityService.getCityInfo("TestCity")).willReturn(new CityInfo(city, testTemp));

    // perform the test by making simulated HTTP get using URL of "/city/TestCity"
    MockHttpServletResponse response = mvc.perform(get("/api/cities/TestCity"))
        .andReturn().getResponse();

    // verify that result is as expected
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    // convert returned data from JSON string format to City object
    // Need a blank constructor for CityInfo for this to work
    CityInfo cityResult = jsonCityAttempt.parseObject(response.getContentAsString());

    CityInfo expectedResult = new CityInfo(1, "TestCity", "USA", "United States", "DistrictTest",
        123456, 98.2, "06:13 PM");


		// compare actual return data with expected data
    // MUST implement .equals( ) method for City class.
		assertThat(cityResult).isEqualTo(expectedResult);

  }

  @Test
  public void cityNotFound() throws Exception {

    Country country = new Country("USA", "United States");
    City city = new City(1, "TestCity", "DistrictTest", 123456, country);
    List<City> cities = new ArrayList<City>();
    TempAndTime testTemp = new TempAndTime(309.93, 1593566001, -14400);
    cities.add(city);

    given(cityService.getCityInfo("TestCity")).willReturn(new CityInfo(city, testTemp));

    // perform the test by making simulated HTTP get using URL of "/city/TestCity"
    MockHttpServletResponse response = mvc.perform(get("/api/cities/TestCity1"))
        .andReturn().getResponse();

    // verify that result is as expected
    assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
  }

  @Test
  public void cityMultiplesFound() throws Exception {

    Country country = new Country("USA", "United States");
    City city = new City(1, "Los Angeles", "DistrictTest", 123456, country);
    List<City> cities = new ArrayList<City>();
    TempAndTime testTemp = new TempAndTime(309.93, 1593566001, -14400);
    cities.add(city);

    given(cityService.getCityInfo("Los Angeles")).willReturn(new CityInfo(city, testTemp));

    // perform the test by making simulated HTTP get using URL of "/city/TestCity"
    MockHttpServletResponse response = mvc.perform(get("/api/cities/Los Angeles"))
        .andReturn().getResponse();

    // verify that result is as expected
    assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    // convert returned data from JSON string format to City object
    // Need a blank constructor for CityInfo for this to work
    CityInfo cityResult = jsonCityAttempt.parseObject(response.getContentAsString());

    CityInfo expectedResult = new CityInfo(1, "Los Angeles", "USA", "United States", "DistrictTest",
        123456, 98.2, "06:13 PM");

    // compare actual return data with expected data
    // MUST implement .equals( ) method for City class.
    assertThat(cityResult).isEqualTo(expectedResult);
  }

}