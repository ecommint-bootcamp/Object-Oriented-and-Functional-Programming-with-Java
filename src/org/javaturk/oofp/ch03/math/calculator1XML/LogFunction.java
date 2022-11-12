package org.javaturk.oofp.ch03.math.calculator1XML;


public class LogFunction implements MathFunction {
	private static String name = "Log";

	public String getName() {
		return name;
	}

	public double calculate(double arg) throws FunctionArgumentValueException {
		if(arg <= 0) {
			throw new FunctionArgumentValueException();
		}
		return Math.log(arg);
	}
}
