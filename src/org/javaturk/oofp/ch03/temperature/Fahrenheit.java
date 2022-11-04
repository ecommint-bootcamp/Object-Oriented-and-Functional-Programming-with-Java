package org.javaturk.oofp.ch03.temperature;

public class Fahrenheit implements TemperatureUnit {

    private static String name="Fahrenheit";

    @Override
    public void calculate() {

    }

    @Override
    public String getName() {
        return name;
    }
}
