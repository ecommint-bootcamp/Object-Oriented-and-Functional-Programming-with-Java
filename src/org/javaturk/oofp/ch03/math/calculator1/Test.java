package org.javaturk.oofp.ch03.math.calculator1;

import org.javaturk.oofp.ch06.assertion.SwitchDemoWithAssertion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		CalculatorT1 calculator1 = new CalculatorT1(8);
		calculator1.addFunction(new SinFunction());
		calculator1.addFunction(new CosFunction());
		calculator1.addFunction(new SquaredFunction());
		calculator1.addFunction(new SquareFunction());
		calculator1.addFunction(new CubeFunction());
		calculator1.addFunction(new SumOfFibonacciFunction());
		calculator1.addFunction(new FactorialFunction());
		calculator1.addFunction(new LogFunction());
//		calculator1.listMathFunction();
		
//		System.out.println();
//		
//		CalculatorT1 calculator2 = new CalculatorT1(5);
//		calculator2.addFunction(new SinFunction());
//		calculator2.addFunction(new CosFunction());
//		calculator2.addFunction(new LogFunction());
//		calculator2.addFunction(new FactorialFunction());
//		calculator2.addFunction(new SquaredFunction());
//		calculator2.listMathFunction();
		
		startCalculator(calculator1);
	}

	private static void startCalculator(CalculatorT1 calculator) {
		calculator.listMathFunction();
		
		System.out.println("Please enter the name of the function:");
		String functionName = in.next();
		if(functionName.equalsIgnoreCase("end"))
			System.exit(0);
		System.out.println("Please enter the argument of the function:");
		try {
			double functionArg = in.nextDouble();
			while (in.nextLine() == null)
				in.nextLine();
			double result = calculator.doCalculation(functionName, functionArg);
			if(result != 1122334455)
				System.out.println(functionName + " of " + functionArg + " is " + result + "\n");

		}
		catch (FunctionArgumentValueException e){
			System.out.println(e.getMessage());

		}catch (InputMismatchException e) {
			System.out.println("You entered the wrong type of entry. Please enter number as argument during application.");
			in.nextLine();
		}
		startCalculator(calculator);
	}
}
