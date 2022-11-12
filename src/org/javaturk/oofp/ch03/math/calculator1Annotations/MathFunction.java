package org.javaturk.oofp.ch03.math.calculator1Annotations;

public interface MathFunction {

	public String  getName();
	
	public double calculate(double arg) throws FunctionArgumentValueException;
	
}
