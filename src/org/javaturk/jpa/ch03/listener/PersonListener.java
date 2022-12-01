package org.javaturk.jpa.ch03.listener;

import javax.persistence.*;

public class PersonListener {
	
	@PrePersist
	public void beforePersist(Person person){
		System.err.println(" ==> beforePersist in PersonListener");
		System.err.println(person);
	}
	
	@PostPersist
	public void afterPersist(Person person){
		System.err.println(" ==> afterPersist in PersonListener");
		System.err.println(person);
	}
	
	@PreRemove
	public void beforeRemove(Person person){
		System.err.println(" ==> beforeRemove in PersonListener");
		System.err.println(person);
	}
	
	@PostRemove
	public void afterRemove(Person person){
		System.err.println(" ==> afterRemove in PersonListener");
		System.err.println(person);
	}
	
	@PreUpdate
	public void beforeUpdate(Person person){
		System.err.println(" ==> beforeUpdate in PersonListener");
		System.err.println(person);
	}
	
	@PostUpdate
	public void afterUpdate(Person person){
		System.err.println(" ==> afterUpdate in PersonListener");
		System.err.println(person);
	}

	@PostLoad
	public void afterLoad(Person person){
		System.err.println(" ==> afterLoad in PersonListener");
		System.err.println(person);
	}
}
