package org.javaturk.jpa.ch05.many2many.bidirection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Car")
@Table(name = "CarMany2ManyBiDir")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String make;
	private String model;
	@Column(name="PRODYEAR")
	private String year;

	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinTable(name = "PersonCarMany2ManyBi", 
				joinColumns = @JoinColumn(name = "CarID"), 
				inverseJoinColumns = @JoinColumn(name = "PersonID"))
	private List<Person> owners;

	public Car() {
		owners = new ArrayList<Person>();
	}

	public Car(String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
		owners = new ArrayList<Person>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Person>  getOwners() {
		return owners;
	}

	public void setOwners(List<Person>  owners) {
		this.owners = owners;
	}

	public void addOwner(Person person) {
		owners.add(person);
	}
	
	public void deleteOwner(Person owner){
		owners.remove(owner);
//		for(int i = 0; i<owners.size(); i++){
//			Person retrievedPerson = owners.get(i);
//			if(owner.getId() == retrievedPerson.getId()){
//				owners.remove(i);
//			}
//		}
	}

	public String toString() {
		return "Car [id=" + id + ", make=" + make + ", model=" + 
					 model + " year=" + year + "number of owners=" + owners.size() + "]";
	}
}
