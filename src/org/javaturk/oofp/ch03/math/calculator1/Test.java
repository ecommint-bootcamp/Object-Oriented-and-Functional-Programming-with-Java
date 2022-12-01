package javaturk.oofp.ch03.math.calculator1;

import java.util.Scanner;

public class Test {
	private static Scanner in;

	public static void main(String[] args) throws ExceptionHandling {
		in = new Scanner(System.in);
		
		CalculatorT1 calculator1 = new CalculatorT1(5);
		calculator1.addFunction(new SinFunction());
		calculator1.addFunction(new CosFunction());
		calculator1.addFunction(new NumberOfSquare());
		calculator1.addFunction(new NumberOfCube());
		calculator1.addFunction(new SumOfFibonacciNumber());
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

	private static void startCalculator(CalculatorT1 calculator) throws ExceptionHandling {
		calculator.listMathFunction();
		
		System.out.println("Please enter the name of the function:");
		String functionName = in.next();
		try {
			if(functionName.equalsIgnoreCase("end"))
				System.exit(0);
			  	System.out.println("Please enter the argument of the function:");
				  try {
					  double functionArg = in.nextDouble();
					  double result = calculator.doCalculation(functionName, functionArg);
					  System.out.println(functionName + " of " + functionArg + " is " + result + "\n");
				  }
				  catch (Exception e){
					  throw new ExceptionHandling("Wrong data type or mismatch.Check your input.");
				  }
		}
		catch (Exception e){
			throw new ExceptionHandling("Wrong data type or mismatch.Check your input.");
		}
		/*if(functionName.equalsIgnoreCase("end"))
			System.exit(0);
		System.out.println("Please enter the argument of the function:");
		double functionArg = in.nextDouble(); 
		double result = calculator.doCalculation(functionName, functionArg);
		System.out.println(functionName + " of " + functionArg + " is " + result + "\n");*/
		
		startCalculator(calculator);
	}
}
