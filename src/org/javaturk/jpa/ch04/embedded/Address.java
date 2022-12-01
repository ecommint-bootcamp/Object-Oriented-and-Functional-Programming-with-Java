package org.javaturk.jpa.ch04.embedded;

import javax.persistence.*;

@Embeddable
public class Address{
	
	@Column(name = "STREET", nullable = false)  
	private String street;
	
	@Column(name = "APPT", nullable = false)  
	private String appt;
	
	@Column(name = "CITY", nullable = false)
	private String city;
	
	@Column(name = "ZIPCODE", nullable = false)  
	private String zipCode;

	// getters and setters
	public String getAppt() {
		return appt;
	}

	public void setAppt(String appt) {
		this.appt = appt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String toString(){
		return appt + " " + street + " " + city + " " + zipCode;
	}
}
