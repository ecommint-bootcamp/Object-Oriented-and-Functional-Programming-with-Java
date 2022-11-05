package org.javaturk.oofp.hw1.degree;


public abstract class Degree implements Convertable {
    protected String type;
    protected double degree;

    public Degree(String type, double degree) {
        this.type = type;
        this.degree = degree;
    }

    public double getDegree() {
        return degree;
    }

    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "Degree{" +
                "type='" + type + '\'' +
                ", degree=" + degree +
                '}';
    }
}
