package org.javaturk.jpa.ch08.entity.factory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="Consultant")
@Table(name="QConsultant")
public class Consultant extends Person{
	
	@Column(name="DAILYRATE", nullable=true, scale=2, precision=6)
	protected float dailyRate;
	
	@Column(name="NUMBEROFDAYS")
	protected int numberOfDays;
	
	@OneToOne(mappedBy = "consultant")
	protected Project project;

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
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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
