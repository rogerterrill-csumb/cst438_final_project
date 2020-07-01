package cst438hw2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import cst438hw2.domain.TempAndTime;

@Service
public class WeatherService {

  private static final Logger log =
      LoggerFactory.getLogger(WeatherService.class);
  private RestTemplate restTemplate;
  private String weatherUrl;
  private String apiKey;

  public WeatherService(    //1
      @Value("${weather.url}") final String weatherUrl,
      @Value("${weather.apikey}") final String apiKey) {
    this.restTemplate = new RestTemplate();
    this.weatherUrl = weatherUrl;
    this.apiKey = apiKey;
  }

  public TempAndTime getTempAndTime(String cityName) {
    ResponseEntity<JsonNode> response =
        restTemplate.getForEntity(
            weatherUrl + "?q=" + cityName + "&appid=" +
                apiKey,
            JsonNode.class);
    JsonNode json = response.getBody();   // 2
    System.out.println(json);
    log.info("Status code from weather server:" +
        response.getStatusCodeValue());
    double temp = json.get("main").get("temp").asDouble();
    long time = json.get("dt").asLong();
    int timezone = json.get("timezone").asInt();
    return new TempAndTime(temp, time, timezone);
  }
}

