package org.javaturk.oofp.ch03.math.calculator1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		CalculatorT1 calculator1 = new CalculatorT1(3);
		calculator1.addFunction(new SinFunction());
		calculator1.addFunction(new CosFunction());
		calculator1.addFunction(new SquareFunction());
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
		
		try {
			System.out.println("Please enter the name of the function:");
			String functionName = in.next(); 
			if(functionName.equalsIgnoreCase("end"))
				System.exit(0);
			System.out.println("Please enter the argument of the function:");
			double functionArg = in.nextDouble(); 
			double result = 0;
			result = calculator.doCalculation(functionName, functionArg);
			System.out.println(functionName + " of " + functionArg + " is " + result + "\n");
		} catch (InvalidFunctionException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		
		startCalculator(calculator);
	}
}
