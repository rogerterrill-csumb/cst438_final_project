package cst438_FinalProject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
  @Id
  private long id;
  private String fname;
  private String lname;
  private String email;
  private long carid;
  private long flightid;
  private long hotelid;

  public User() {};

  public User(long id, String fname, String lname, String email, long carid, long flightid,
      long hotelid) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.carid = carid;
    this.flightid = flightid;
    this.hotelid = hotelid;
  }
}
