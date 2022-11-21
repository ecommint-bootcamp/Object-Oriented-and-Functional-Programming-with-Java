package temperatureconverter.domain;

import java.util.Arrays;
import java.util.List;

public enum Temperature {
	K("Kelvin"), F("Fahrenheit "), C("Celsius");
	
	private String description;
	
	private Temperature(String description) {
		this.description = description;
	}
	
	public static List<Temperature> getTemperatureList(){
		List<Temperature> list =Arrays.asList(Temperature.values());
		return list;
	}
	
	public static Temperature switchToTemperature(String temperatureString) {
		Temperature temperature = null;
		switch (temperatureString) {
		case "K":
			temperature = Temperature.K;
			break;
			
		case "F":
			temperature = Temperature.F;
			break;
			
		case "C":
			temperature = Temperature.C;
			break;
		}	
		
		return temperature;
	}
}
