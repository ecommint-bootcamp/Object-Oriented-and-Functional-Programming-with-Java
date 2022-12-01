package org.javaturk.jpa.ch08.graph;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
@NamedEntityGraph(name = "graph.Order.items", attributeNodes = @NamedAttributeNode(value = "items", subgraph = "items"), subgraphs = @NamedSubgraph(name = "items", attributeNodes = @NamedAttributeNode("product")))
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private long id;

	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private String orderNumber;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<OrderItem> items = new HashSet<OrderItem>();

	public Order() {
	}

	public Order(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
		item.setOrder(this);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Order [id=" + id + ", version=" + version + ", orderNumber=" + orderNumber + ", items="
				+ items.size() + " items in Order.] ");
		for (OrderItem item : items)
			sb.append(item);
		return sb.toString();
	}
}