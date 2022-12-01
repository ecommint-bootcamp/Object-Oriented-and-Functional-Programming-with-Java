package org.javaturk.jpa.ch04.id.composite2;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static javax.persistence.FetchType.LAZY;

@Entity(name = "Person")
@Table(name="PersonIdentityComposite2")
public class Person implements Serializable{
	
	@EmbeddedId
	private Name name;

	public Person() {}
	
	public Person(Name name) {
		this.name = name;
	}

	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	public String getFirstName(){
		return name.getFirstName();
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}
}
