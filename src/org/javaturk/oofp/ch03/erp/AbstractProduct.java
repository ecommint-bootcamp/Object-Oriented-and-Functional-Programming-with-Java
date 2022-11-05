package org.javaturk.oofp.ch03.erp;

import javax.swing.text.StyledEditorKit;

public abstract class AbstractProduct implements Product {
    protected String sku;
    protected String description;
    protected double price;
    protected double tax;
    protected Location location;

    protected Boolean isGifted = false;



    AbstractProduct(String sku, String description, double price, double tax, Location location) {
        this.sku = sku;

        this.description = description;

        this.price = price;

        this.tax = tax;

        this.location = location;

    }

    public Boolean getGiftedInfo() {
        return isGifted;
    }

    private void setGiftedInfo(Boolean gifted) {
        isGifted = gifted;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void gift(){
        setGiftedInfo(true);
        setTax(0);
        setPrice(0);
    }


}
