package resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import converter.ITemperatureConverter;
import converter.TemperatureConverterImpl;
import domain.Conversion;
import domain.Conversions;

@Path("/conversions")
public class TemperatureConverterServiceImpl implements TemperatureConverterService {

	private Conversions conversions = new Conversions();
	private ITemperatureConverter temperatureConverter = new TemperatureConverterImpl();

	@Override
	@POST
	@Path("{from}/{to}/{degree}")
	public Conversion convert(@PathParam("from") String from, @PathParam("to") String to,
			@PathParam("degree") double degree) {

		double converterResult = temperatureConverter.convert(from, to, degree);
		Conversion conversion = new Conversion();
		conversion = new Conversion(from, to, degree, converterResult);
		conversions.addConversion(conversion);
		return conversion;
	}

	@Override
	@GET
	@Produces("application/json")
	@Path("/conversionList")
	public List<String> getSupportedConversions() {
		return conversions.getSupportedConversions();
	}

	@Override
	@GET
	@Produces("application/json")
	public List<Conversion> getConversions() {
		Conversions conversions = new Conversions();

		return conversions.getConversions();
	}

}
