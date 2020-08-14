package cst438_FinalProject.domain;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Flight {

	//@Id
	//@GeneratedValue
	//private long id;

	private String email;
	private String seatClass;
	private int numPassengers;
	private boolean prioBoarding; 
	private int flightID;



	public Flight() {}

	public Flight(String email, String seatClass, 
			int numPassengers, boolean prioBoarding, int flightID) {
		this.email = email;
		this.seatClass = seatClass;
		this.numPassengers = numPassengers;
		this.prioBoarding = prioBoarding;
		this.flightID = flightID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public int getNumPassengers() {
		return numPassengers;
	}

	public void setNumPassengers(int numPassengers) {
		this.numPassengers = numPassengers;
	}

	public boolean isPrioBoarding() {
		return prioBoarding;
	}

	public void setPrioBoarding(boolean prioBoarding) {
		this.prioBoarding = prioBoarding;
	}

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	@Override
	public String toString() {
		return "Flight {email=" + email + 
				", seatClass=" + seatClass + 
				", numPassengers=" + numPassengers + 
				", prioBoarding=" + prioBoarding + 
				", flightID=" + flightID + 
				"}";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + flightID;
		result = prime * result + numPassengers;
		result = prime * result + (prioBoarding ? 1231 : 1237);
		result = prime * result + ((seatClass == null) ? 0 : seatClass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flightID != other.flightID)
			return false;
		if (numPassengers != other.numPassengers)
			return false;
		if (prioBoarding != other.prioBoarding)
			return false;
		if (seatClass == null) {
			if (other.seatClass != null)
				return false;
		} else if (!seatClass.equals(other.seatClass))
			return false;
		return true;
	}
}