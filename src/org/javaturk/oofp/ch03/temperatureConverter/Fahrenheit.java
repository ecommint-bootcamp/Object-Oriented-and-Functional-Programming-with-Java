package org.javaturk.oofp.ch03.temperatureConverter;

public class Fahrenheit implements UnitTemperature {
	private static String name = "Fahrenheit";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double convert(String to, double arg) {
		double result;
		switch (to) {
		case "Kelvin":
			result = (arg + 459.67) * 5 / 9;
			break;
		case "Celsius":
			result = (arg - 32) * 5 / 9;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + to);
		}
		return result;
	}

}
