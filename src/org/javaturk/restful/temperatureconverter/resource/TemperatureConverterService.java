package org.javaturk.restful.temperatureconverter.resource;

import org.javaturk.restful.temperatureconverter.domain.Conversion;
import org.javaturk.restful.temperatureconverter.domain.Conversions;
import org.javaturk.restful.temperatureconverter.domain.Temperature;

import java.util.List;

public interface CurrencyConverterService {

    Conversions getAllConversion();

    List<Temperature> getAllTemperatures();

    Conversion convert(Conversion conversionParameter);

    Conversion convert(Temperature sourceTemperature, Temperature targetTemperature, double amount);

    Conversion convertString(String sourceTemperatureString, String targetTemperatureString, double amount);

    Conversion convertStringXML(String sourceTemperatureString, String targetTemperatureString, double amount);

}
