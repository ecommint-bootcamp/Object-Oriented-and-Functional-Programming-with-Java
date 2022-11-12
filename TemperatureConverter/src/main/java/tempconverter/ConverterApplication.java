package tempconverter;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import tempconverter.resource.TemperatureConverterResource;

@ApplicationPath("/resources")
public class ConverterApplication extends Application {

	Set<Object> singletons = new HashSet<>();
	
	public Set<Object> getSingletons(){
		singletons.add(new TemperatureConverterResource());
		return singletons;
	}
}
