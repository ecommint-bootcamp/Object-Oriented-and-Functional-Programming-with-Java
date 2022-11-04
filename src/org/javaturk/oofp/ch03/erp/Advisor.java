package org.javaturk.oofp.ch03.erp;

public class Advisor {
    String name;
    String title;
    String areaOfExpertise;

    public Advisor(String name, String title, String areaOfExpertise) {
        this.name = name;
        this.title = title;
        this.areaOfExpertise = areaOfExpertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }
}
