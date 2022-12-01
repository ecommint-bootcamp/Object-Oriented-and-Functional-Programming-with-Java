package org.javaturk.jpa.ch05.collection.basicTypes.list;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity(name = "Person")
@Table(name="PersonBasicTypesList")
public class Person {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	
//	@ElementCollection(targetClass=String.class)
	@ElementCollection(fetch=FetchType.LAZY)
//	@ElementCollection
	@CollectionTable(name="PHONELISTFORPERSON", joinColumns={@JoinColumn(name="PERSONID")})
//	@OrderColumn(name="INDEXOFPHONE")
	@OrderBy("PHONES ASC") // Don't use OrderColumn when using OrderBy
	private List<String> phones;

	public Person() {
		phones = new ArrayList<>();
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		phones = new ArrayList<>();
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
	
	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
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


