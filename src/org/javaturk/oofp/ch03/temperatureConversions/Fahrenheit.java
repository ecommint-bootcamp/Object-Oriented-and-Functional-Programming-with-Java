package org.javaturk.oofp.ch03.temperatureConversions;

public class Fahrenheit implements Converter {
	
	@Override
    public void convert(int temp) {
        int celcius = (temp - 32) * 5 / 9;
        int kelvin = (temp - 32) * 5 / 9 + 273;

        System.out.println("Fahrenheit -> Celcius: " + celcius);
        System.out.println("Fahrenheit -> Kelvin: " + kelvin);
    }
	
}
