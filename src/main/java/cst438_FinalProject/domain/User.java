package cst438_FinalProject.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import cst438_FinalProject.domain.*;

@Entity
@Table(name="user")
public class User {
	
  @Id
  private int id;
  
  private String fname;
  private String lname;
  private String email;
  private long carid;
  private long flightid;
  private long hotelid;

  public User() { }

  public User(int id, String fname, String lname, String email, long carid, long flightid,
      long hotelid) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.carid = carid;
    this.flightid = flightid;
    this.hotelid = hotelid;
  }
  
  // Constructor for using loginUser to create a User
  public User(LoginUser loginUser) {
	  this.fname = loginUser.getFname();
	  this.lname = loginUser.getLname();
	  this.email = loginUser.getEmail();
	  //Set some default value for carid, hotelid, flightid
	  this.carid = 0;
	  this.flightid = 0;
	  this.hotelid = 0;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public long getCarid() {
    return carid;
  }

  public void setCarid(long carid) {
    this.carid = carid;
  }

  public long getFlightid() {
    return flightid;
  }

  public void setFlightid(long flightid) {
    this.flightid = flightid;
  }

  public long getHotelid() {
    return hotelid;
  }

  public void setHotelid(long hotelid) {
    this.hotelid = hotelid;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", fname='" + fname + '\'' +
        ", lname='" + lname + '\'' +
        ", email='" + email + '\'' +
        ", carid=" + carid +
        ", flightid=" + flightid +
        ", hotelid=" + hotelid +
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
    User user = (User) o;
    return id == user.id &&
        carid == user.carid &&
        flightid == user.flightid &&
        hotelid == user.hotelid &&
        fname.equals(user.fname) &&
        lname.equals(user.lname) &&
        email.equals(user.email);
  }
}
