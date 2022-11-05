package org.javaturk.oofp.hw1.degree;



public class Kelvin extends Degree{
    Kelvin(double degree) {
        super("Kelvin", degree);
    }

    @Override
    public String toString() {
        return " Degree type = " + type + "\n" + degree + " " + type + "\n" + toFahrenheit() + " Fahrenheit" + "\n" + toCelcius() + " Celcius";
    }

    @Override
    public double toFahrenheit() {
        return toCelcius() * 1.8 + 32;
    }

    @Override
    public double toCelcius() {
        return degree - 273.15;
    }

    @Override
    public double toKelvin() {
        return degree;
    }
}
