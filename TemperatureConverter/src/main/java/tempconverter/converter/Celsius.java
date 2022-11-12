package tempconverter.converter;

public class Celsius extends Temperature {
	
	public Celsius(double degree) {
		super(degree);
	}

	@Override
	public double convertToCelsius() {
		return super.getDegree();
	}

	@Override
	public double convertToFahrenheit() {
		return super.getDegree() * 1.8 + 32;
	}

	@Override
	public double convertToKelvin() {
		return super.getDegree() + 273.15;
	}
	
	
}
