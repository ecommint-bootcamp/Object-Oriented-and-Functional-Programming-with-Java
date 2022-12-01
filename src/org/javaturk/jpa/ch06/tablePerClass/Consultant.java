package org.javaturk.jpa.ch06.tablePerClass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ConsultantInheritanceTPC")
public class Consultant extends Person{
	
	protected float dailyRate;
	protected int numberOfDays;

	public Consultant(){}
	
	public Consultant(String firstName, String lastName, float dailyRate) {
		super(firstName, lastName);
		this.dailyRate = dailyRate;
	}

	public float getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(float dailyRate) {
		this.dailyRate = dailyRate;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public float calculatePayment(){
		return numberOfDays * dailyRate;
	}

	public String toString() {
		return "Consultant [dailyRate=" + dailyRate + ", numberOfDays="
				+ numberOfDays + ", id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
}
