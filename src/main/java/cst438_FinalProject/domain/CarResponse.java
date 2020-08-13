package cst438_FinalProject.domain;

public class CarResponse {
	  
	  private int reservationID;
	  private String email;
	  private String pickupLocation;
	  

	  private String pickupDate;
	  private String returnLocation;

	  private String returnDate;
	  private int carID;
	  private int total;
	  
	  CarResponse(){}

	  
	
	  
	public CarResponse(int reservationID, String email, String pickupLocation, String pickupDate, String returnLocation,
			String returnDate, int carID, int total) {
		super();
		this.reservationID = reservationID;
		this.email = email;
		this.pickupLocation = pickupLocation;
		this.pickupDate = pickupDate;
		this.returnLocation = returnLocation;
		this.returnDate = returnDate;
		this.carID = carID;
		this.total = total;
	}




	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
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

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}




	@Override
	public String toString() {
		return "CarResponse [reservationID=" + reservationID + ", email=" + email + ", pickupLocation=" + pickupLocation
				+ ", pickupDate=" + pickupDate + ", returnLocation=" + returnLocation + ", returnDate=" + returnDate
				+ ", carID=" + carID + ", total=" + total + "]";
	}
	  
	  
	
}
