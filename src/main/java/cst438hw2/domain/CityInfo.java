package cst438hw2.domain;

import java.util.Objects;

public class CityInfo {

  long id;
  String name;
  String countryCode;
  String countryName;
  String district;
  int population;
  double temp;
  String time;

  public CityInfo() {};

  public CityInfo(City city, TempAndTime tempAndTime) {
    this.id = city.getId();
    this.name = city.getName();
    this.countryCode = city.getCountry().getCode();
    this.countryName = city.getCountry().getName();
    this.district = city.getDistrict();
    this.population = city.getPopulation();
    this.temp = tempAndTime.getFormattedTemp();
    this.time = tempAndTime.getFormattedTime();
  }

  public CityInfo(long id, String name, String countryCode, String countryName,
      String district, int population, double temp, String time) {
    this.id = id;
    this.name = name;
    this.countryCode = countryCode;
    this.countryName = countryName;
    this.district = district;
    this.population = population;
    this.temp = temp;
    this.time = time;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public double getTemp() {
    return temp;
  }

  public void setTemp(double temp) {
    this.temp = temp;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  @Override
  public String toString() {
    return "CityInfo{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", countryCode='" + countryCode + '\'' +
        ", countryName='" + countryName + '\'' +
        ", district='" + district + '\'' +
        ", population=" + population +
        ", temp=" + temp +
        ", time='" + time + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CityInfo cityInfo = (CityInfo) o;
    return id == cityInfo.id &&
        population == cityInfo.population &&
        Double.compare(cityInfo.temp, temp) == 0 &&
        Objects.equals(name, cityInfo.name) &&
        Objects.equals(countryCode, cityInfo.countryCode) &&
        Objects.equals(countryName, cityInfo.countryName) &&
        Objects.equals(district, cityInfo.district) &&
        Objects.equals(time, cityInfo.time);
  }
}
