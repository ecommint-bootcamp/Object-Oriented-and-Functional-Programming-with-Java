package org.javaturk.oofp.ch03.erp;

public class AdvisingService extends Service{
    protected Advisor advisor;

    public AdvisingService(String sku, String description, double price, double tax, Advisor advisor) {
        super(sku, description, price, tax);
        this.advisor=advisor;
    }

    @Override
    public void purchase() {
        System.out.println("Advising service " + description + " is purchased at the price of " + price + " with the tax of " + tax
                + "\nfrom the advisor: " + advisor );

    }
}
