package cst438_FinalProject.domain;


import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel { //These fields were obtain from the Hotel Reservation ERD, shared by Jasper Kolp and may change

  @Id
  @GeneratedValue
  private long id;

  private String hotel_name;
  private String check_in;
  private String check_out;
  private float total_rooms;
  private float total_price;

  public Hotel(){};

  public Hotel(long id, String hotel_name, String check_in, String check_out, float total_rooms,
      float total_price) {
    this.id = id;
    this.hotel_name = hotel_name;
    this.check_in = check_in;
    this.check_out = check_out;
    this.total_rooms = total_rooms;
    this.total_price = total_price;
  }

  public Hotel(String hotel_name, String check_in, String check_out, float total_rooms,
      float total_price) {
    this.hotel_name = hotel_name;
    this.check_in = check_in;
    this.check_out = check_out;
    this.total_rooms = total_rooms;
    this.total_price = total_price;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getHotel_name() {
    return hotel_name;
  }

  public void setHotel_name(String hotel_name) {
    this.hotel_name = hotel_name;
  }

  public String getCheck_in() {
    return check_in;
  }

  public void setCheck_in(String check_in) {
    this.check_in = check_in;
  }

  public String getCheck_out() {
    return check_out;
  }

  public void setCheck_out(String check_out) {
    this.check_out = check_out;
  }

  public float getTotal_rooms() {
    return total_rooms;
  }

  public void setTotal_rooms(float total_rooms) {
    this.total_rooms = total_rooms;
  }

  public float getTotal_price() {
    return total_price;
  }

  public void setTotal_price(float total_price) {
    this.total_price = total_price;
  }

  @Override
  public String toString() {
    return "Hotel{" +
        "hotel_name='" + hotel_name + '\'' +
        ", check_in='" + check_in + '\'' +
        ", check_out='" + check_out + '\'' +
        ", total_rooms=" + total_rooms +
        ", total_price=" + total_price +
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
    Hotel hotel = (Hotel) o;
    return Float.compare(hotel.total_rooms, total_rooms) == 0 &&
        Float.compare(hotel.total_price, total_price) == 0 &&
        hotel_name.equals(hotel.hotel_name) &&
        check_in.equals(hotel.check_in) &&
        check_out.equals(hotel.check_out);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hotel_name, check_in, check_out, total_rooms, total_price);
  }
}
