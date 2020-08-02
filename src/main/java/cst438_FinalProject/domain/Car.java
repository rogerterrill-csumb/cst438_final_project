package cst438_FinalProject.domain;

import javax.persistence.Id;

public class Car {


	
	  @Id
	  private long id;
	  private String fname;
	  private String lname;
	  private String email;
	  private String pickupLocation;
	  private String pickupDate;
	  private String returnLocation;
	  private String returnDate;
	  private String type;
	  
	public Car () {}  
	  
	public Car(long id, String fname, String lname, String email, String pickupLocation, String pickupDate,
			String returnLocation, String returnDate, String type) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pickupLocation = pickupLocation;
		this.pickupDate = pickupDate;
		this.returnLocation = returnLocation;
		this.returnDate = returnDate;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getReturnLocation() {
		return returnLocation;
	}

	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	  
	  
	  
}
