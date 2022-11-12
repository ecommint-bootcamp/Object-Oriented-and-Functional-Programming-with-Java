package tempconverter.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import tempconverter.converter.TemperatureConverter;
import tempconverter.converter.TemperatureConverterEngine;
import tempconverter.domain.Conversion;
import tempconverter.domain.Conversions;

@Path("/conversions")
public class TemperatureConverterResource implements TemperatureConverterService {
	
	private Conversions conversions = new Conversions();
	private TemperatureConverter converter = new TemperatureConverterEngine();

	@Override
	@GET
	@Produces("application/json")
	public List<Conversion> getConversions() {
		return conversions.getConversions();
	}

	@Override
	@POST
	@Path("{from}/{to}/{temp}")
	@Produces("application/json")
	public Conversion convert(@PathParam("from") String from, @PathParam("to") String to, @PathParam("temp") double temp) {
		double result = converter.convert(from, to, temp);
		Conversion conversion = new Conversion(from, to, temp, result);
		conversions.addConversion(conversion);
		return conversion;
	}

	@Override
	@GET
	@Produces("application/json")
	@Path("/get-supported-conversions")
	public List<String> getSupportedConversions() {
		return conversions.getSupportedConversions();
	}
}
