package cst438hw2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438hw2.domain.*;

@Service
public class CityService {
  @Autowired
  private CityRepository cityRepository;
  @Autowired
  private WeatherService weatherService;

  public CityInfo getCityInfo(String cityName) {
    List<City> c = cityRepository.findByName(cityName);
    if(c.size() == 0){
      return null;
    }
    City city = c.get(0);
    TempAndTime cityTemp = weatherService.getTempAndTime(city.getName());

    return new CityInfo(city, cityTemp);
  }
}
