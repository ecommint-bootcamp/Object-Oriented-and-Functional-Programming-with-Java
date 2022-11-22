package org.javaturk.oofp.ch03.temperatureConverter;

public interface Converter {
	
	public void addTemperature(UnitTemperature temperature);
	
	public void listUnitTemperature();
	
	public double doConvertion(String from, String to, double arg) throws InvalidFunctionException;
}
