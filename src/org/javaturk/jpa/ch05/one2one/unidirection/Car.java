package org.javaturk.jpa.ch05.one2one.unidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Car")
@Table(name="CarOne2OneUniDir")
public class Car {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String make;
	private String model;
	
	@Column(name="PROYEAR")
	private String year;

	public Car() {
	}

	public Car(String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public Car(int id, String make, String model, String year) {
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model
				+ ", year=" + year + "]";
	}
}
