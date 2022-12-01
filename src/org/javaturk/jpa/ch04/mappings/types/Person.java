package org.javaturk.jpa.ch04.mappings.types;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name="PersonTypes")
public class Person {

	@Id
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NAMECHARS")
	private char[] namesChars;

	@Column(name = "SEX")
	private char sex;

	@Column(name = "AGE")
	private int age;

	@Column(name = "SALARY")
	private long salary;

	@Column(name = "RATE")
	private float rate;

	@Column(name = "BONUS")
	private double bonus;

	@Column(name = "MARRIED")
	private boolean married;
	
	@Column(name = "DOBDATE")
	private java.util.Date dob1;
	
	@Column(name = "DOBSQLDATE")
	private java.sql.Date dob2;

	public Person() {}	

	public Person(int id, String name, char sex, int age, long salary, float rate, double bonus, boolean married,
			Date dob1, java.sql.Date dob2) {
		super();
		this.id = id;
		this.name = name;
		this.namesChars = name.toCharArray();
		this.sex = sex;
		this.age = age;
		this.salary = salary;
		this.rate = rate;
		this.bonus = bonus;
		this.married = married;
		this.dob1 = dob1;
		this.dob2 = dob2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		namesChars = this.name.toCharArray();
		System.out.println(this.namesChars);
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public java.util.Date getDob1() {
		return dob1;
	}

	public void setDob1(java.util.Date dob1) {
		this.dob1 = dob1;
	}

	public java.sql.Date getDob2() {
		return dob2;
	}

	public void setDob2(java.sql.Date dob2) {
		this.dob2 = dob2;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", salary=" + salary + ", rate=" + rate
				+ ", bonus=" + bonus + ", married=" + married + "]";
	}
}
