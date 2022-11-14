package org.javaturk.oofp.ch03.erp;

public class GiftProduct extends Product{

    public GiftProduct(String sku, String description, Location location) {
        super(sku, description, location);
    }

    public void give(){
        System.out.println(sku + " Product was given as a gift");
    }
}
