package org.javaturk.jpa.ch05.one2one.bidirection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity(name = "Person")
@Table(name="PersonOne2OneBiDir")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	
//	@OneToOne(mappedBy="owner", optional=false, cascade=CascadeType.REMOVE, fetch=FetchType.EAGER, orphanRemoval=true)
	//JoinColumn does not work here because it is a bi-directional association and
	//it works on the target's side
	@OneToOne(mappedBy="owner", cascade= {CascadeType.PERSIST}, fetch=FetchType.LAZY, orphanRemoval=true)
//	@OneToOne(mappedBy="owner", optional=false, fetch=FetchType.LAZY)
//	@JoinColumn(name="OwnerID")
//	@LazyToOne(LazyToOneOption.NO_PROXY)
//	@LazyToOne(LazyToOneOption.NO_PROXY)
	private Car car;

	public Person() {
	}

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
//		car.setOwner(this);
	}

	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", car=" + car + "]";
	}
}
