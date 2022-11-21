package org.yabdioglu.springCalculator.annotation;

import org.springframework.stereotype.Component;

@Component
public class CosFunction implements MathFunction {
	private static String name = "Cos";

	public String getName() {
		return name;
	}
	
	public double calculate(double arg) {
		return Math.cos(arg);
	}
}
