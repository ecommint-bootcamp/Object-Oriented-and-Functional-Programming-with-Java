package org.javaturk.oofp.ch03.erp;

public abstract class PricedProduct implements Product {
    protected String sku;
    protected String description;
    protected double price;
    protected double tax;

    public PricedProduct(String sku, String description, double price, double tax) {
        this.sku = sku;
        this.description = description;
        this.price = price;
        this.tax = tax;
    }


    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
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

    @Override
    public String toString() {
        return "Priced Product's" +
                "sku='" + sku + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", tax=" + tax +
                '}';
    }

    @Override
    public abstract void purchase();

}
