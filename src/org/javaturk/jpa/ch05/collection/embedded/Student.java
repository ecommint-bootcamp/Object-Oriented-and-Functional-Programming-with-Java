package org.javaturk.jpa.ch05.collection.embedded;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity(name="Student")
@Table(name="StudentCollectionEmbedding")
public class Student {

	@Id
	private long id;
	private String firstName;
	private String lastName;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="ADRESSFORSTUDENT", joinColumns={@JoinColumn(name="STUDENTID")})
	private Set<Address> addresses = new HashSet<Address>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String toString() {
		return "Student [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
}
