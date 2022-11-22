package org.javaturk.oofp.ch03.temperatureConverter;

import java.util.Scanner;

public class Test {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		Converter converter = new ConverterEngine(3);
		converter.addTemperature(new Fahrenheit());
		converter.addTemperature(new Celsius());
		converter.addTemperature(new Kelvin());

		
		startConverter(converter);
	}
	
	private static void startConverter(Converter converter) {
		converter.listUnitTemperature();
		
		System.out.println("Please enter the name of the input :");
		String from = in.next();
		System.out.println("Please enter the name of the output :");
		String to = in.next(); 
		if(from.equalsIgnoreCase("end"))
			System.exit(0);
		System.out.println("Please enter the argument of the function:");
		double functionArg = in.nextDouble(); 
		double result = 0;
		try {
			result = converter.doConvertion(from, to, functionArg);
		} catch (InvalidFunctionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(from + "to " + to + " "+ functionArg + " is " + result + "\n");
		
		startConverter(converter);
	}

}
