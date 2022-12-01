package org.javaturk.jpa.ch05.collection.basicTypes.map;


import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity(name = "Person")
@Table(name="PersonBasicTypesMap")
public class Person {

	@Id
	private int id;
	private String firstName;
	private String lastName;
	
	@ElementCollection
	@CollectionTable(name="PHONEMAPFORPERSON", joinColumns={@JoinColumn(name="PERSONID")})
//	@MapKeyClass(Integer.class)
	private Map<Integer, String> phones;
	
//	@Column(name="PhoneIndex")
	@Transient
	private int phoneIndex = 1;

	public Person() {
		phones = new HashMap<Integer, String>();
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		phones = new HashMap<Integer, String>();
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
	
	public Map getPhones() {
		return phones;
	}

	public void setPhones(Map phones) {
		this.phones = phones;
	}

	public void addPhone(String phone){
		phones.put(phoneIndex, phone);
		phoneIndex++;
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


