package org.javaturk.oofp.ch03.math.calculator1Annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("calculator")
public class CalculatorT1 implements Calculator{

	private int functionCount;
	private int currentCount = 0;
	
	private MathFunction[] functions;
	private double argument;

	public CalculatorT1(@Value(value = "8") int functionCount) {
		this.functionCount = functionCount;
		functions = new MathFunction[functionCount];
		System.out.println("Calculator created");
	}

	@Override
	public void addFunction(MathFunction function) {
		functions[currentCount] = function;
		currentCount++;
	}

//	public void doCalculation(MathFunction function, double arg) {
//		System.out.println(function.getName() + "(" + arg + ") = " + function.calculate(arg));
//	}

	@Override
	public double doCalculation(String functionName, double arg) throws FunctionArgumentValueException {
		double result = 0.0;
		boolean isFunctionFound = false;
		for (MathFunction function : functions) {
			if (functionName.equalsIgnoreCase(function.getName())) {
				result = function.calculate(arg);
				isFunctionFound = true;
			}
		}
		if(!isFunctionFound) {
			System.out.println("No such function found!");
			return 1122334455;
		}

		return result;
	}



	@Override
	public void listMathFunction() {
		System.out.println("Available Functions:");
		for (MathFunction function : functions)
			System.out.println(function.getName());
	}
}
