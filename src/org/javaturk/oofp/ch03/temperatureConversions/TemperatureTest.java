package org.javaturk.oofp.ch03.temperatureConversions;

public class TemperatureTest {
	  public static void main(String[] args) {
		  
	     System.out.println("Kelvin");
	         Converter kelvin = new Kelvin();
	         Template a = new Template(kelvin);
	         a.calculate(100);
	     System.out.println(" ");
	     System.out.println("Celcius");    
	         Converter celcius = new Celcius();
	         Template b = new Template(celcius);
	         b.calculate(100);
	     System.out.println(" ");
	     System.out.println("Fahrenheit");    
	         Converter fahrenheit = new	Fahrenheit();
	         Template c = new Template(fahrenheit);
	         c.calculate(100);
	    }
}
