package org.javaturk.oofp.ch03.erp;

public class Computer implements Inventory{

    private String brand;

    private String model;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void sell() {
        System.out.println(brand + " branded computer sold");
    }
}
