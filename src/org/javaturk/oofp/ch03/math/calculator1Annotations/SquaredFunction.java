package org.javaturk.oofp.ch03.math.calculator1Annotations;

import org.springframework.stereotype.Component;

@Component("squaredfunction")
public class SquaredFunction implements MathFunction{
	
	private static String name = "Squared";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double calculate(double arg1) throws FunctionArgumentValueException {
		if(arg1 <= 0) {
			throw new FunctionArgumentValueException();
		}
		return Math.sqrt(arg1);
	}
}
