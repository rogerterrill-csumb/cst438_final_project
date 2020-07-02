package cst438hw2.controller;

import cst438hw2.domain.City;
import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.Country;
import cst438hw2.domain.CountryRepository;
import cst438hw2.domain.TempAndTime;
import cst438hw2.service.CityService;
import cst438hw2.service.WeatherService;
import java.util.ArrayList;
import java.util.List;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CityServiceTest {

  @MockBean
  private WeatherService weatherService;

  @MockBean
  private CityRepository cityRepository;

  @Autowired
  private CityService cityService;

  @Test
  public void testCityFound() throws Exception {
    Country country = new Country("USA", "United States");
    City city = new City(1, "TestCity", "DistrictTest", 123456, country);

    // Create an empty cities list to be used on the given
    List<City> cities = new ArrayList<City>();
    cities.add(city);

    // create the stub calls and return data for weather service
    //  when the getWeather method is called with name parameter "TestCity",
    //  the stub will return the given temp (in degrees Kelvin) and time.
    given(weatherService.getTempAndTime("TestCity"))
        .willReturn(new TempAndTime(309.93, 1593566001, -14400));

    // this is the stub for the CityRepository.  When given input parm of "TestCity",
    // it will return a list of cities.
    given(cityRepository.findByName("TestCity")).willReturn(cities);

    CityInfo cityResult = cityService.getCityInfo("TestCity");
    CityInfo expectedResult = new CityInfo(1, "TestCity", "USA", "United States", "DistrictTest",
        123456, 98.2, "06:13 PM");

    // Assertions
    assertThat(cityResult).isEqualTo(expectedResult);
  }

  @Test
  public void testCityNotFound() throws Exception {
    Country country = new Country("USA", "United States");
    City city = new City(1, "TestCity", "DistrictTest", 123456, country);

    // Create an empty cities list to be used on the given
    List<City> cities = new ArrayList<City>();
    cities.add(city);

    // this is the stub for the CityRepository.  When given input parm of "TestCity",
    // it will return a list of cities.
    given(cityRepository.findByName("TestCity")).willReturn(cities);

    CityInfo cityResult = cityService.getCityInfo("TestCity1");
    CityInfo expectedResult = null;

    // Assertions
    assertThat(cityResult).isEqualTo(expectedResult);
  }

  @Test
  public void testMultipleCities() throws Exception {
    Country country = new Country("USA", "United States");
    City city = new City(1, "Los Angeles", "DistrictTest", 123456, country);

    // Create an empty cities list to be used on the given
    List<City> cities = new ArrayList<City>();
    cities.add(city);

    // create the stub calls and return data for weather service
    //  when the getWeather method is called with name parameter "TestCity",
    //  the stub will return the given temp (in degrees Kelvin) and time.
    given(weatherService.getTempAndTime("Los Angeles"))
        .willReturn(new TempAndTime(309.93, 1593566001, -14400));

    // this is the stub for the CityRepository.  When given input parm of "TestCity",
    // it will return a list of cities.
    given(cityRepository.findByName("Los Angeles")).willReturn(cities);

    CityInfo cityResult = cityService.getCityInfo("Los Angeles");
    CityInfo expectedResult = new CityInfo(1, "Los Angeles", "USA", "United States", "DistrictTest",
        123456, 98.2, "06:13 PM");

    // Assertions
    assertThat(cityResult).isEqualTo(expectedResult);
  }
}
