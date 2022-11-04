package org.javaturk.oofp.ch03.erp;

public abstract class Service extends PricedProduct {
    public Service(String sku, String description, double price, double tax) {
        super(sku, description, price, tax);
    }

    @Override
    public abstract void purchase();
}
