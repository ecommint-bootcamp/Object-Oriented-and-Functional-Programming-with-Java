package org.javaturk.oofp.ch03.temperatureConverter;

public interface UnitTemperature {
	
	public String getName();
	
	public double convert(String to, double arg);
}
