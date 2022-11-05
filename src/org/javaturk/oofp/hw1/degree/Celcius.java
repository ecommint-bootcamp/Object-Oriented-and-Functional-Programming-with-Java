package org.javaturk.oofp.hw1.degree;

public class Celcius extends Degree {
    Celcius(double degree) {
        super("Celcius", degree);
    }

    @Override
    public String toString() {
        return " Degree type = " + type + "\n" + degree + " " + type + "\n" + toFahrenheit() + " Fahrenheit" + "\n" + toKelvin() + " Kelvin";
    }

    @Override
    public double toFahrenheit() {
        return degree * 1.8 + 32;
    }

    @Override
    public double toCelcius() {
        return degree;
    }

    @Override
    public double toKelvin() {
        return degree + 273.15;
    }
}
