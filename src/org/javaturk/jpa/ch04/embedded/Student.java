package org.javaturk.jpa.ch04.embedded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Student")
@Table(name="StudentEmbedding")
public class Student {

	@Id //signifies the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name="street", column=@Column(name="ST_STRT")),
        @AttributeOverride(name="appt", column=@Column(name="ST_APT")),
        @AttributeOverride(name="city", column=@Column(name="ST_CTY")),
        @AttributeOverride(name="zipCode", column=@Column(name="ST_ZCD"))
    })
	private Address address = new Address();

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "Student [Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}
}
