package org.javaturk.oofp.ch03.temperatureConverter;

public class Kelvin implements UnitTemperature {
	private static String name = "Kelvin";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double convert(String to, double arg) {
		double result;
		switch (to) {
		case "Fahrenheit":
			result = (arg - 273.15) * 9 / 5 + 32;
			break;
		case "Celsius":
			result = arg - 273.15;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + to);
		}
		return result;
	}

}
