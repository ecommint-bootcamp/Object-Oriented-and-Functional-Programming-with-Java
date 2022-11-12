package org.javaturk.oofp.ch03.math.calculator1Annotations;

import org.springframework.stereotype.Component;

@Component("factorialfunction")
public class FactorialFunction implements MathFunction {
	private static final String name = "Factorial";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double calculate(double arg) throws FunctionArgumentValueException {
		return calculateFactorial(arg);
	}

	private int calculateFactorial(double arg) throws FunctionArgumentValueException {
		if(arg <= 0) {
			throw new FunctionArgumentValueException();
		}
		int k = (int) arg;
		int factorial = 1;
		
		for(int i = 2; i <= k ; i++){
			factorial *= i;
			
		}
		return factorial;
	}

}
