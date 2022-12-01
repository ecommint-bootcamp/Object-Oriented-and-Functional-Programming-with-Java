package org.javaturk.jpa.ch03.listener;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Person")
@EntityListeners({PersonListener.class})
@Table(name="PersonListener")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy="owners")
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

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public void addCar(Car car){
		cars.add(car);
//		car.addOwner(this);
	}
	
	public void deleteCar(Car car){
		
		for(int i = 0; i<cars.size(); i++){
			Car retrievedCar = cars.get(i);
			if(car.getId() == retrievedCar.getId()){
				cars.remove(i);
			}
		}
		
//		Iterator i = cars.iterator();
//		while(i.hasNext()){
//			Car retrievedCar = (Car) i.next();
//			if(car.getId() == retrievedCar.getId())
//				i.remove();
//		}
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", cars=" + cars + "]";
	}
}