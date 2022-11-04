package org.javaturk.oofp.ch03.math.calculator1;

public class SquareRootFunction implements MathFunction{
	
	private static String name = "Square Root";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double calculate(double arg1) {
		return Math.sqrt(arg1);
	}
}
