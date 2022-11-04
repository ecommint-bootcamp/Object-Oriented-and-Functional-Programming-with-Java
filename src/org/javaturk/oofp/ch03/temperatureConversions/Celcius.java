package org.javaturk.oofp.ch03.temperatureConversions;

public class Celcius implements Converter {
	
	@Override
    public void convert(int temp) {
        int fahrenheit = (temp * 9 / 5) + 32;
        int kelvin = temp + 273;

        System.out.println("Celcius -> Fahrenheit: " + fahrenheit);
        System.out.println("Celcius -> Kelvin: " + kelvin);
    }
	

}
