package org.javaturk.jpa.ch05.many2many.unidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name="PersonMany2ManyUniDir")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(name = "PersonCarUni", 
				joinColumns = @JoinColumn(name = "PersonID"), 
				inverseJoinColumns = @JoinColumn(name = "CarID"))
	private List<Car> cars;

	public Person() {
		cars = new ArrayList<Car>();
	}

	public Person(String firstName, String lastName) {
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

	public List getCars() {
		return cars;
	}

	public void setCars(List cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car){
		cars.add(car);
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", cars=" + cars + "]";
	}
}
