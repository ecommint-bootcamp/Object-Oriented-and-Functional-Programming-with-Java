package Application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import resources.TemperatureConverterServiceImpl;

@ApplicationPath("/resources")
public class ConverterApplication extends Application {
	Set<Object> singletons = new HashSet<>();

	@Override
	public Set<Object> getSingletons() {
		singletons.add(new TemperatureConverterServiceImpl());

		return singletons;
	}

}
