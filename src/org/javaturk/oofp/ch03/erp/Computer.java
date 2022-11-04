package org.javaturk.oofp.ch03.erp;

public abstract class Computer implements InventoryProduct {

    protected String model;
    protected String age;

    public Computer(String model, String age) {
        this.model = model;
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void giveaway(){

    }
}
