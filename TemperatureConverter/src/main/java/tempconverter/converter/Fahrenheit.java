package tempconverter.converter;

public class Fahrenheit extends Temperature {
	
	public Fahrenheit(double degree) {
		super(degree);
	}

	@Override
	public double convertToCelsius() {
		return (super.getDegree() - 32) / 1.8;
	}

	@Override
	public double convertToFahrenheit() {
		return super.getDegree();
	}

	@Override
	public double convertToKelvin() {
		return (super.getDegree() + 459.67) * (5.0 / 9);
	}
	
	
}
