package org.javaturk.spring.di.calculator1SpringwithXML;


public class LogFunction implements MathFunction {
	private static String name = "Log";

	public String getName() {
		return name;
	}

	public double calculate(double arg) {
		return Math.log(arg);
	}
}
