package org.javaturk.oofp.hw1.degree;



public class Fahrenheit extends Degree{

    Fahrenheit(double degree) {
        super("Fahrenheit", degree);
    }

    @Override
    public String toString() {
        return " Degree type = " + type + "\n" + degree + " " + type + "\n" + toCelcius() + " Celcius" + "\n" + toKelvin() + " Kelvin";
    }

    @Override
    public double toFahrenheit() {
        return degree ;
    }

    @Override
    public double toCelcius() {
        return (degree - 32) / 1.8;
    }

    @Override
    public double toKelvin() {
        return toCelcius() + 273.15;
    }
}
