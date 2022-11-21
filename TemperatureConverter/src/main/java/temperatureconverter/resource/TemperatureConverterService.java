package temperatureconverter.resource;

import java.util.List;

import temperatureconverter.domain.Conversion;
import temperatureconverter.domain.Conversions;
import temperatureconverter.domain.Temperature;


public interface TemperatureConverterService {
	Conversions getAllConversions();

	List<Temperature> getAllTemperatures();

	Conversion convert(temperatureconverter.domain.Temperature sourceTemperature, Temperature targetTemperature, double amount);

}
