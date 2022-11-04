package org.javaturk.oofp.ch03.erp;

public abstract class GiftProduct implements Product {
    protected String sku;
    protected String description;

    public GiftProduct(String sku, String description) {
        this.sku = sku;
        this.description = description;
    }

    @Override
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Gift Product's : " +
                "sku='" + sku + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}
