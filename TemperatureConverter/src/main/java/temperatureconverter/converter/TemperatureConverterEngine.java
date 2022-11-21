package temperatureconverter.converter;

import temperatureconverter.domain.Conversion;
import temperatureconverter.domain.Temperature;

import static temperatureconverter.domain.Temperature.*;

public class TemperatureConverterEngine implements TemperatureConverter {
	
	@Override
	public Conversion convert(Conversion conversion) {
		double targetAmount = convert(conversion.getSourceTemperature(), conversion.getTargetTemperature(),
				conversion.getSourceAmount());
		conversion.setTargetAmount(targetAmount);
		return conversion;
	}

	@Override
	public double convert(Temperature sourceTemperature, Temperature targetTemperature, double sourceAmount) {
		double targetAmount = 0;
		// First check if source and target currencies are the same.
		if(sourceTemperature.equals(targetTemperature))
			return sourceAmount;
		if (sourceTemperature.equals(K)) {
			switch (targetTemperature) {
			case F:
				targetAmount = (sourceAmount - 273.15) * 9 / 5 + 32;
				break;
			case C:
				targetAmount = sourceAmount - 273.15;
				break;
			}
		} else if (sourceTemperature.equals(F)) {
			switch (targetTemperature) {
			case C:
				targetAmount = (sourceAmount - 32) * 5 / 9;
				break;
			case K:
				targetAmount = (sourceAmount - 32) * 9 / 5 + 273.15;
				break;
			}
		} else if (sourceTemperature.equals(C)) {
			switch (targetTemperature) {
			case F:
				targetAmount = (sourceAmount * 9 / 5) + 32;
				break;
			case K:
				targetAmount = sourceAmount + 273.15;
				break;
			}
		}
		return targetAmount;
	}

}
