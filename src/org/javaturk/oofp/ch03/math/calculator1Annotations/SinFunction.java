package org.javaturk.oofp.ch03.math.calculator1Annotations;

import org.springframework.stereotype.Component;

@Component("sinfunction")
public class SinFunction implements MathFunction {
	
	private static String name = "Sin";

	public String getName() {
		return name;
	}
	
	@Override
	public double calculate(double arg) {
		return Math.sin(arg);
	}
}
