package tempconverter.converter;

public abstract class Temperature implements Convertable {
	private double degree;
	
	public Temperature(double degree) {
		this.degree = degree;
	}
	
	public double getDegree() {
		return degree;
	}
	
	public void setDegree(double degree) {
		this.degree = degree;
	}
}
