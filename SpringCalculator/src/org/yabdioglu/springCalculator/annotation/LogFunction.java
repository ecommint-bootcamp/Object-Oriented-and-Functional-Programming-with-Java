package org.yabdioglu.springCalculator.annotation;

import org.springframework.stereotype.Component;

@Component
public class LogFunction implements MathFunction{
	private static String name = "Log";

	public String getName() {
		return name;
	}

	public double calculate(double arg) {
		return Math.log(arg);
	}
}
