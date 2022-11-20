package javaturk.oofp.ch03.math.calculator1;

public interface MathFunction {

	public String getName();
	
	public double calculate(double arg) throws ExceptionHandling;
	
}
