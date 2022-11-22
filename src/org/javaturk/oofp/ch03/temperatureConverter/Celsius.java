package org.javaturk.oofp.ch03.temperatureConverter;

public class Celsius implements UnitTemperature {
	private static String name = "Celsius";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double convert(String to, double arg) {
		double result;
		switch (to) {
		case "Kelvin":
			result = arg + 273.15;
			break;
		case "Fahrenheit":
			result = (arg * 9 / 5) + 32;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + to);
		}
		return result;
	}

}
