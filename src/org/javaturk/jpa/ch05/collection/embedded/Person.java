package org.javaturk.jpa.ch05.collection.embedded;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name="PersonCollectionEmbedding")
public class Person {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="ADRESSFORPERSON", joinColumns={@JoinColumn(name="PERSONID")})
	private Set<Address> addresses = new HashSet<Address>();

	public Person() {}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	
	public boolean addAddress(Address address){
		return addresses.add(address);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
