package org.javaturk.oofp.ch03.erp;

public class ConsultancyProduct extends  AbstractProduct{

    protected Consultant consultant;
    protected String projectName;

    public ConsultancyProduct(String sku, String description, double price, double tax, Location location, Consultant advisor, String projectName) {
        super(sku, description, price, tax, location);
        this.consultant = advisor;
        this.projectName = projectName;
    }

    public Consultant getAdvisor() {
        return consultant;
    }

    public void setAdvisor(Consultant consultant) {
        this.consultant = consultant;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public void purchase() {
        System.out.println("ConsultancyProduct " + description + " is purchased at the price of " + price + " with the tax of " + tax );
    }
}
