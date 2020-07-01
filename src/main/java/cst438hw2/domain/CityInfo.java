package cst438hw2.domain;

public class CityInfo {

  long id;
  String name;
  String countryCode;
  String countryName;
  String district;
  int population;
  double temp;
  String time;

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
}
