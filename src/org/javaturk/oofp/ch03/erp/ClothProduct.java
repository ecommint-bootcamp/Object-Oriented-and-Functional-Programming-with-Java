/**
 * 
 */
package org.javaturk.oofp.ch03.erp;


public class ClothProduct extends AbstractProduct {
	protected String sex;
	protected String size;


	public ClothProduct(String sku, String description, double price, double tax, Location location, String sex, String size) {
		super(sku, description, price, tax, location);
		this.sex = sex;
		this.size = size;
	}


	@Override
	public void purchase() {
		System.out.println("ClothProduct " + description + "for " + sex + " and size " + size + " is purchased at the price of " + price + " with the tax of " + tax );
	}

}
