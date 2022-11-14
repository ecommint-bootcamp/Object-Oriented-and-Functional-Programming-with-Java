package org.javaturk.oofp.ch03.erp;

public class PricedProduct extends Product {
    protected double price;
    protected double tax;

    public PricedProduct(String sku, String description, Location location, double price, double tax) {
        super(sku, description, location);
        this.price = price;
        this.tax = tax;
    }

    public void purchase() {
        System.out.println("Product " + description + " is purchased at the price of " + price + " with the tax of " + tax );
    }
}
