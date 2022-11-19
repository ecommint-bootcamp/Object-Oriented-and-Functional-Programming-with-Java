package entity;

public class Kelvin extends Temperature {

	public Kelvin(double degree) {
		super(degree);
	}

	@Override
	public double convertToKelvin() {
		return super.getDegree();
	}

	@Override
	public double convertToCelcius() {
		return super.getDegree() - 273.15;
	}

	@Override
	public double convertToFahrenheit() {
		return (super.getDegree() - 273.15) * 1.8 + 32;
	}

}
