package org.javaturk.jpa.ch08.graph;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class OrderItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private long id;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private int quantity;

	@ManyToOne
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Product product;
	
	public OrderItem() {}

	public OrderItem(Product product, int quantity) {
		this.quantity = quantity;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", version=" + version + ", quantity=" + quantity + ", order id=" + order.getId()
				+ ", product=" + product + "]";
	}
}
