package cst438_FinalProject.domain;

import javax.persistence.Id;

public class Hotel { //These fields were obtain from the Hotel Reservation ERD, shared by Jasper Kolp and may change
	
	@Id
	  private long customer_ID;
	  private long reservation_ID;
	  private long hotel_ID;
	  private String fname;
	  private String lname;
	  private String email;
	  private String hotelName;
	  private float price_per_night;
	  private float hotelDescription;
	  private String checkInDate;
	  private String checkOutDate;
	  private float total_price;
	
	public Hotel () {}
	
	public Hotel ( long customer_ID, long reservation_ID, long hotel_ID, String fname, String lname, String email,
			 String hotelName, float price_per_night, float hotelDescription, String checkInDate, String checkOutDate,
			 float total_price) {
		super();
	  this.customer_ID = customer_ID;
	  this.reservation_ID = reservation_ID;
	  this.hotel_ID = hotel_ID;
	  this.fname = fname;
	  this.lname = lname;
	  this.email = email;
	  this.hotelName = hotelName;
	  this.price_per_night = price_per_night;
	  this.hotelDescription = hotelDescription;
	  this.checkInDate = checkInDate;
	  this.checkOutDate = checkOutDate;
	  this.total_price = total_price;
	}

	public long getCustomer_ID() {
		return customer_ID;
	}

	public void setCustomer_ID(long customer_ID) {
		this.customer_ID = customer_ID;
	}

	public long getReservation_ID() {
		return reservation_ID;
	}

	public void setReservation_ID(long reservation_ID) {
		this.reservation_ID = reservation_ID;
	}

	public long getHotel_ID() {
		return hotel_ID;
	}

	public void setHotel_ID(long hotel_ID) {
		this.hotel_ID = hotel_ID;
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public float getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(float price_per_night) {
		this.price_per_night = price_per_night;
	}

	public float getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(float hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public float getTotal_price() {
		return total_price;
	}

	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	
}
