package org.javaturk.oofp.ch03.temperatureConverter;

public class ConverterEngine implements Converter {
	private int temperatureCount;
	private int currentCount = 0;
	
	private UnitTemperature[] temperatures;
	private double argument;
	
	public ConverterEngine(int temperatureCount) {
		this.temperatureCount = temperatureCount;
		temperatures = new UnitTemperature[temperatureCount];
	}

	@Override
	public void addTemperature(UnitTemperature temperature) {
		temperatures[currentCount] = temperature;
		currentCount++;
	}

	@Override
	public double doConvertion(String from, String to, double arg) throws InvalidFunctionException {
		double result = 0.0;
		boolean isFunctionFound = false;
		for (UnitTemperature temperature : temperatures) {
			if(from.equalsIgnoreCase(temperature.getName())) {
				result = temperature.convert(to, arg);
				isFunctionFound = true;
			}
		}
		if(!isFunctionFound) {
			throw new InvalidFunctionException("No such function found!" + from);
		}
		
		return result;
	}
	
	@Override
	public void listUnitTemperature() {
		System.out.println("Available Functions:");
		for (UnitTemperature temperature : temperatures)
			System.out.println(temperature.getName());
		
	}

}
