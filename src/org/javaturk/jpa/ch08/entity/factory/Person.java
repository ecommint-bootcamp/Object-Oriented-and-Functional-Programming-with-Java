package org.javaturk.jpa.ch08.entity.factory;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "QPerson")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	@Column(name = "FIRSTNAME", length = 20, nullable = false, insertable = true, updatable = false)
	protected String firstName;

	@Column(name = "LASTNAME", length = 20, nullable = false, insertable = true, updatable = false)
	protected String lastName;

	@OneToOne(mappedBy = "owner")
	protected Car car;

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
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", car=" + car + "]";
	}

}
