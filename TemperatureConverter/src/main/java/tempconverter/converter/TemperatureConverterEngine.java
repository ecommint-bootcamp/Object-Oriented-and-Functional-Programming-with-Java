package tempconverter.converter;

public class TemperatureConverterEngine implements TemperatureConverter {

	@Override
	public double convert(String source, String target, double temperature) {
		double result = 0.0;

		switch (source) {
		case "Celsius": {
			Celsius celsius = new Celsius(temperature);
			if (target.equals("Fahrenheit")) {
				result = celsius.convertToFahrenheit();
			}

			else if (target.equals("Kelvin")) {
				result = celsius.convertToKelvin();
			}
			break;
		}

		case "Fahrenheit": {
			Fahrenheit fahrenheit = new Fahrenheit(temperature);
			if (target.equals("Celcius")) {
				result = fahrenheit.convertToCelsius();
			}

			else if (target.equals("Kelvin")) {
				result = fahrenheit.convertToKelvin();
			}
			break;
		}

		case "Kelvin": {

			Kelvin kelvin = new Kelvin(temperature);
			if (target.equals("Celsius")) {
				result = kelvin.convertToCelsius();
			}

			else if (target.equals("Fahrenheit")) {
				result = kelvin.convertToFahrenheit();
			}
			break;
		}

		}
		return result;

	}

}
