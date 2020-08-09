package cst438_FinalProject.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Car {

	  private String email;
	  private String pickupLocation;
	  

	  private String pickupDate;
	  private String returnLocation;

	  private String returnDate;
	  private String carType;
	  
	public Car () {}  
	  
	public Car(String email, String pickupLocation, String pickupDate,
			String returnLocation, String returnDate, String carType) {
		this.email = email;
		this.pickupLocation = pickupLocation;
		this.pickupDate = changeDateFormat(pickupDate);
		this.returnLocation = returnLocation;
		this.returnDate = changeDateFormat(returnDate);
		this.carType = carType;
	}
	
	public String changeDateFormat(String inputDate) {
        String year =  inputDate.substring(0,4);
		String month = inputDate.substring(5,7);
        String day = inputDate.substring(8,10);
        
		
		return month + "/" + day + "/" + year;
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
		this.pickupDate = changeDateFormat(pickupDate);
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
		this.returnDate = changeDateFormat(returnDate);
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "Car [email=" + email + ", pickupLocation=" + pickupLocation + ", pickupDate=" + pickupDate
				+ ", returnLocation=" + returnLocation + ", returnDate=" + returnDate + ", carType=" + carType + "]";
	}


	  
	  
}
