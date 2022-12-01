package org.javaturk.jpa.ch05.collection.basicTypes.set;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity(name = "Person")
@Table(name="PersonBasicTypesSet")
public class Person {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	
//	@ElementCollection(targetClass=String.class)
	@ElementCollection
	@CollectionTable(name="PHONESETFORPERSON", joinColumns={@JoinColumn(name="PERSONID")})
	@OrderBy
	private Set<String> phones;

	public Person() {
		phones = new TreeSet<String>();
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		phones = new TreeSet<String>();
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

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(HashSet<String> phones) {
		this.phones = phones;
	}
	
	public boolean addPhone(String phone){
		return phones.add(phone);
	}

	public String toString() {
		return "Person [firstName=" + firstName + ", id=" + id + ", lastName="
				+ lastName + "]";
	}
	
	@Override
	public boolean equals(Object o){
		boolean b = false;
		Person p = (Person) o;
		if(id == p.getId())
			b = true;
		return b;
	}
	
	@Override
	public int hashCode(){
		return id;
	}
}


