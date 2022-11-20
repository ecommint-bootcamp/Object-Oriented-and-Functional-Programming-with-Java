package javaturk.oofp.ch03.math.calculator1;

public class SinFunction implements MathFunction {
	
	private static String name = "Sin";

	public String getName() {
		return name;
	}
	
	@Override
	public double calculate(double arg) throws ExceptionHandling {
		try {
			return Math.sin(arg);
		}
		catch (Exception e){
			throw new ExceptionHandling("Wrong data type. Check your input.");
		}
	}
}
