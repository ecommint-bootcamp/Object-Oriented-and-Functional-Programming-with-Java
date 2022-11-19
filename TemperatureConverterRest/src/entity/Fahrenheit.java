package entity;

public class Fahrenheit extends Temperature {

	public Fahrenheit(double degree) {
		super(degree);
	}

	@Override
	public double convertToKelvin() {
		return (super.getDegree() + 459.67) * (5.0 / 9);
	}

	@Override
	public double convertToCelcius() {
		return (super.getDegree() - 32) / 1.8;
	}

	@Override
	public double convertToFahrenheit() {
		return super.getDegree();
	}

}
