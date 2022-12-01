package org.javaturk.jpa.ch05.one2many.list.bidirection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name="PersonOne2ManyBiDir")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	
//	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)//, orphanRemoval=true, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, orphanRemoval=true)
//	@OneToMany(mappedBy="owner", orphanRemoval=true)
	private List<Car> cars;
	
	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		cars = new ArrayList<Car>();
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		cars = new ArrayList<Car>();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car){
		cars.add(car);
		car.setOwner(this);
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", cars=" + cars + "]";
	}

	public void deleteCar(Car car) {
		cars.remove(car);
	}
}
