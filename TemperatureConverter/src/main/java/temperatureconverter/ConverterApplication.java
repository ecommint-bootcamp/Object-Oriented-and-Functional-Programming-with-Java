package temperatureconverter;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import temperatureconverter.resource.TemperatureConverterResource;

@ApplicationPath("/resources")
public class ConverterApplication extends Application {
	Set<Object> singletons = new HashSet<>();

	/**
	 * To make service object a singleton.
	 */
	public Set<Object> getSingletons() {
//		System.out.println("In getSingletons()");
		singletons.add(new TemperatureConverterResource());
		return singletons;
	}
}
