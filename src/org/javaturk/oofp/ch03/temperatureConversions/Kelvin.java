package org.javaturk.oofp.ch03.temperatureConversions;

public class Kelvin implements Converter {
		
	@Override
    public void convert(int temp) {
        int celcius = temp - 273;
        int fahrenheit = (temp - 273) * 9 / 5 + 32;

        System.out.println("Kelvin -> Celcius: " + celcius);
        System.out.println("Kelvin -> Fahrenheit: " + fahrenheit);
    }
	 
}
