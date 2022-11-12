package tempconverter.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Conversions {
	
	private List<Conversion> conversions = Collections.synchronizedList(new ArrayList<>());
	private List<String> conversionTypeList = Arrays.asList("Celsius", "Fahrenheit", "Kelvin");

	public Conversions() {
	}

	public void addConversion(Conversion conversion) {
		conversions.add(conversion);
	}

	public List<Conversion> getConversions() {
		return conversions;
	}

	public void setConversions(List<Conversion> list) {
		conversions = list;
	}
	
	public List<String> getSupportedConversions() {
		return conversionTypeList;
	}

}
