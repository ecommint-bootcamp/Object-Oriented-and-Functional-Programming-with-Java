package converter;

import entity.Celcius;
import entity.Fahrenheit;
import entity.Kelvin;

public class TemperatureConverterImpl implements ITemperatureConverter {

	@Override
	public double convert(String from, String to, double degree) {
		double converterResult = 0;

		switch (from) {
		case "Celcius": {
			Celcius celcius = new Celcius(degree);
			if (to.equals("Fahrenheit")) {
				converterResult = celcius.convertToFahrenheit();
			} else if (to.equals("Kelvin")) {
				converterResult = celcius.convertToKelvin();
			}
			break;

		}
		case "Kelvin": {
			Kelvin kelvin = new Kelvin(degree);
			if (to.equals("Celcius")) {
				converterResult = kelvin.convertToCelcius();
			} else if (to.equals("Fahrenheit")) {
				converterResult = kelvin.convertToFahrenheit();
			}
			break;
		}
		case "Fahrenheit": {
			Fahrenheit fahrenheit = new Fahrenheit(degree);
			if (to.equals("Celcius")) {
				converterResult = fahrenheit.convertToCelcius();
			} else if (to.equals("Kelvin")) {
				converterResult = fahrenheit.convertToKelvin();
			}
			break;
		}

		}
		return converterResult;

	}

}
