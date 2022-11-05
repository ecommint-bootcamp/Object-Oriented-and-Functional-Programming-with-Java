package org.javaturk.oofp.ch03.erp;

public class Computer extends  AbstractInventory{

    protected String brand;

    protected String model;


    public Computer(String sku, String description, double price, double tax, String brand, String model) {
        super(sku, description, price, tax);
        this.brand = brand;
        this.model = model;
    }


    @Override
    public void purchase() {
        System.out.println("Computer Inventory " + description + " is purchased at the price of " + price + " with the tax of " + tax );
    }
}
