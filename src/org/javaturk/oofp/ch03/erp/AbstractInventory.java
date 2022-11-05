package org.javaturk.oofp.ch03.erp;

public abstract class  AbstractInventory extends AbstractProduct{

    protected final Location LOCATION = new Location("CompanyAddress", "Company");

    AbstractInventory(String sku, String description, double price, double tax) {
        super(sku, description, price, tax, new Location("CompanyAddress", "Company"));
    }

}
