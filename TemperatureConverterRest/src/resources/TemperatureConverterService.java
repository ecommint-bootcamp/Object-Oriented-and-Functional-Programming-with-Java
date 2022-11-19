package resources;

import java.util.List;

import domain.Conversion;

public interface TemperatureConverterService {

	public Conversion convert(String from, String to, double degree);

	public List<String> getSupportedConversions();

	public List<Conversion> getConversions();

}
