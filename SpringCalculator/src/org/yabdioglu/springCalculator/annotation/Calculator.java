package org.yabdioglu.springCalculator.annotation;

public interface Calculator {
	public void addFunction(MathFunction function);
	
	public void listMathFunction();
	
	public double doCalculation(String functionName, double arg);
	
	public void setFunctions(MathFunction[] functions);
}
