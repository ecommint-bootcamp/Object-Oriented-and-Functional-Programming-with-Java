package org.javaturk.jpa.ch14.lazyCollection;

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
@Table(name="PersonPerformance")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)//, orphanRemoval=true, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	private List<Car> cars1;
	
	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)//, orphanRemoval=true, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	private List<Car> cars2;
	
	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)//, orphanRemoval=true, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	private List<Car> cars3;
	
	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)//, orphanRemoval=true, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	private List<Car> cars4;
	
	@OneToMany(mappedBy="owner", cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, orphanRemoval=true)//, orphanRemoval=true, fetch=FetchType.EAGER, cascade={CascadeType.PERSIST})
	private List<Car> cars5;
	
	public Person() {
		cars1 = new ArrayList<Car>();
		cars2 = new ArrayList<Car>();
		cars3 = new ArrayList<Car>();
		cars4 = new ArrayList<Car>();
		cars5 = new ArrayList<Car>();
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		cars1 = new ArrayList<Car>();
		cars2 = new ArrayList<Car>();
		cars3 = new ArrayList<Car>();
		cars4 = new ArrayList<Car>();
		cars5 = new ArrayList<Car>();
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		cars1 = new ArrayList<Car>();
		cars2 = new ArrayList<Car>();
		cars3 = new ArrayList<Car>();
		cars4 = new ArrayList<Car>();
		cars5 = new ArrayList<Car>();
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
	
	public List<Car> getCars1() {
		return cars1;
	}

	public void setCars1(List<Car> cars1) {
		this.cars1 = cars1;
	}

	public List<Car> getCars2() {
		return cars2;
	}

	public void setCars2(List<Car> cars2) {
		this.cars2 = cars2;
	}

	public List<Car> getCars3() {
		return cars3;
	}

	public void setCars3(List<Car> cars3) {
		this.cars3 = cars3;
	}

	public List<Car> getCars4() {
		return cars4;
	}

	public void setCars4(List<Car> cars4) {
		this.cars4 = cars4;
	}

	public List<Car> getCars5() {
		return cars5;
	}

	public void setCars5(List<Car> cars5) {
		this.cars5 = cars5;
	}

	public void addCar1(Car car){
		cars1.add(car);
		car.setOwner(this);
	}
	
	public void addCar2(Car car){
		cars2.add(car);
		car.setOwner(this);
	}
	
	public void addCar3(Car car){
		cars3.add(car);
		car.setOwner(this);
	}
	
	public void addCar4(Car car){
		cars4.add(car);
		car.setOwner(this);
	}
	
	public void addCar5(Car car){
		cars5.add(car);
		car.setOwner(this);
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", cars=" + cars1 + "]";
	}
}
