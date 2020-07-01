package cst438hw2.domain;

import javax.persistence.*;

@Entity
@Table(name="city")
public class City {
  @Id
  private long id;
  private String name;
  private String district;
  private int population;

  @ManyToOne
  @JoinColumn(name="countrycode", referencedColumnName="code")
  private Country country;

  public City() {};

  public City(long id, String name, String district, int population, Country country) {
    this.id = id;
    this.name = name;
    this.district = district;
    this.population = population;
    this.country = country;
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

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "City{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", district='" + district + '\'' +
        ", population=" + population +
        ", country=" + country +
        '}';
  }
}
