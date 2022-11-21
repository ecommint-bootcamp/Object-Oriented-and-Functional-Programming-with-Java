package org.yabdioglu.springCalculator.annotation;

import org.springframework.stereotype.Component;

@Component
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
