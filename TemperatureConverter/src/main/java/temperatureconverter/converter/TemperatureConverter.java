package temperatureconverter.converter;

import temperatureconverter.domain.Conversion;
import temperatureconverter.domain.Temperature;

public interface TemperatureConverter {

	public double convert(Temperature sourceTemperature, Temperature targetTemperature, double sourceAmount);
	
	public Conversion convert(Conversion conversion);
}
