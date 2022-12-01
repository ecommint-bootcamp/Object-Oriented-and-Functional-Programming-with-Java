package org.javaturk.jpa.ch04.mappings.serializable;

import java.io.Serializable;

public class Car implements Serializable{
	
	private int id;
	private String make;
	private String model;
	private String year;

//	private boolean isConvertable;
//	private String plate;

//	private Person owner;

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

	@Override
	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + "]";
	}

//	public boolean isConvertable() {
//		return isConvertable;
//	}
//
//	public void setConvertable(boolean isConvertable) {
//		this.isConvertable = isConvertable;
//	}
//
//	public String getPlate() {
//		return plate;
//	}
//
//	public void setPlate(String plate) {
//		this.plate = plate;
//	}

//	@Override
//	public String toString() {
//		return "Car [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", isConvertable="
//				+ isConvertable + ", plate=" + plate + "]";
//	}
	

//	public Person getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Person owner) {
//		this.owner = owner;
////		owner.setCar(this);
//	}


}
