package org.javaturk.jpa.ch05.one2many.map.bidirection;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Person")
@Table(name="PersonOne2ManyMapBiDir")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy="owner", orphanRemoval=true, fetch=FetchType.LAZY, cascade={CascadeType.PERSIST})
	@MapKey(name="id")
	private Map<Integer, Car> cars;

	public Person() {
		cars = new HashMap<Integer, Car>();
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		cars = new HashMap<Integer, Car>();
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

	public Map<Integer, Car> getCars() {
		return cars;
	}

	public void setCars(Map<Integer, Car> cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car){
		cars.put(car.getId(), car);
		car.setOwner(this);
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", cars=" + cars + "]";
	}
}
