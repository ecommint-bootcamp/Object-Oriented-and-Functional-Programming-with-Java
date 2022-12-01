
package org.javaturk.jpa.ch07.concurrency.domain;

import javax.persistence.*;

@Entity
public class Coffee {
	
	@Id
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private float price;
	
	@Column(name = "SALES")
	private int sales;
	
	public Coffee(){}
	
	public Coffee(String name, float price, int sales) {
		this.name = name;
		this.price = price;
		this.sales = sales;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", sales=" + sales + "]";
	}
}
