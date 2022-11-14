/**
 * 
 */
package org.javaturk.oofp.ch03.erp;


public abstract class Product {
	protected String sku;
	protected String description;
	protected Location location;
	
	/**
	 * @param sku
	 * @param description
	 * @param price
	 * @param tax
	 * @param location
	 */
	public Product(String sku, String description, Location location) {
		this.sku = sku;
		this.description = description;
		this.location = location;
	}

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
