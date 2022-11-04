/**
 * 
 */
package org.javaturk.oofp.ch03.erp;


public abstract class Good extends PricedProduct {

	protected Location location;

	public Good(String sku, String description, double price, double tax, Location location) {
		super(sku, description, price, tax);
		this.location = location;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public abstract void purchase();
}
