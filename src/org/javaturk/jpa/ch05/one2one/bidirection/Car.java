package org.javaturk.jpa.ch05.one2one.bidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Car")
@Table(name="CarOne2OneBiDir")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String make;
	private String model;
	@Column(name="PROYEAR")
	private String year;
	
	@OneToOne(optional=true)
	@JoinColumn(name="OwnerId") 
	private Person owner;

	public Car() {
	}

	public Car(String make, String model, String year) {
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
//		owner.setCar(this);
	}

	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model
				+ " year=" + year + "]";
	}
}
