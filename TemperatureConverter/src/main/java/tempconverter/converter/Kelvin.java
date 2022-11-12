package tempconverter.converter;

public class Kelvin extends Temperature {
	
	public Kelvin(double degree) {
		super(degree);
	}

	@Override
	public double convertToCelsius() {
		return super.getDegree() - 273.15;
	}

	@Override
	public double convertToFahrenheit() {
		return (super.getDegree() - 273.15) * 1.8 + 32;
	}

	@Override
	public double convertToKelvin() {
		return super.getDegree();
	}
	
	
}
