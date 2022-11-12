package tempconverter.resource;

import java.util.List;

import tempconverter.domain.Conversion;

public interface TemperatureConverterService {
	public List<Conversion> getConversions();

	public Conversion convert(String from, String to, double value);

	public List<String> getSupportedConversions();
}
