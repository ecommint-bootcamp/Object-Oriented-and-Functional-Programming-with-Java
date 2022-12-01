package org.javaturk.jpa.ch04.id.composite3;

import java.io.Serializable;

public class Name implements Serializable{

	// Only get methods for id fields because ids can't be changed.
	private String firstName;
	private String lastName;
	
	public Name(){}

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public boolean equals(Object object){
		if(object instanceof Name){
			Name name = (Name) object;
			if(firstName.equals(name.getFirstName()) && lastName.equals(name.getLastName()))
				return true;
			else 
				return false;
		}
		return false;
	}
	
	public int hashCode(){
		return firstName.hashCode() + lastName.hashCode();
	}

	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}	
}
