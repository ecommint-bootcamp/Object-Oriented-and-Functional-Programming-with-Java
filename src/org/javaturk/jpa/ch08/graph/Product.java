package org.javaturk.jpa.ch08.graph;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", updatable = false, nullable = false)
	private long id;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@Column
	private String name;
	
	public Product() {}
	
	public Product(String name) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", version=" + version + ", name=" + name + "]";
	}
}
