package temperatureconverter.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import temperatureconverter.converter.TemperatureConverter;
import temperatureconverter.converter.TemperatureConverterEngine;
import temperatureconverter.domain.Conversion;
import temperatureconverter.domain.Conversions;
import temperatureconverter.domain.Temperature;

@Path("/conversions")
public class TemperatureConverterResource implements TemperatureConverterService {
	
	private static Conversions conversions = new Conversions();
	private TemperatureConverter converter = new TemperatureConverterEngine();

	@Override
	@GET
	@Produces("application/json")
	public Conversions getAllConversions() {
		Conversions conversions = new Conversions();
		conversions.setConversions(TemperatureConverterResource.conversions.getConversions());
		return conversions;
	}

	@Override
	@Path("/temperatures")
	@GET
	@Produces("application/json")
	public List<Temperature> getAllTemperatures() {
		return Temperature.getTemperatureList();
	}

	@Override
	@POST
	@Path("{from}/{to}/{amount}")
	@Produces("application/json")
	public Conversion convert(@PathParam("from") Temperature sourceTemperature, @PathParam("to") Temperature targetTemperature, @PathParam("amount") double amount) {
		Conversion conversion = null;
		double targetAmount = converter.convert(sourceTemperature, targetTemperature, amount);
		conversion = new Conversion(sourceTemperature, targetTemperature, amount, targetAmount);
		conversions.addConversion(conversion);
		return conversion;
	}
}
