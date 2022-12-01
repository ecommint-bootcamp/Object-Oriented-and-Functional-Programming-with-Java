package org.javaturk.jpa.ch05.one2many.set.bidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "Car")
@Table(name="CarOne2ManySetBiDir")
public class Car {
	
	@Id
	private int id;
	private String make;
	private String model;
	@Column(name="PROYEAR")
	private String year;
	
	@ManyToOne
	@JoinColumn(name="OwnerId") 
	private Person owner;

	public Car() {
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

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
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
				+ " year=" + year + "]";
	}
}
