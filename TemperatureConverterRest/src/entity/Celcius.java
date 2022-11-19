package entity;

public class Celcius extends Temperature {

	public Celcius(double degree) {
		super(degree);
	}

	@Override
	public double convertToKelvin() {

		return super.getDegree() + 273.15;
	}

	@Override
	public double convertToCelcius() {

		return super.getDegree();
	}

	@Override
	public double convertToFahrenheit() {

		return super.getDegree() * 1.8 + 32;
	}

}
