package org.javaturk.oofp.ch03.math.calculator3;

import java.util.Objects;
import java.util.Scanner;

public class Test {
	private static Scanner in;

	public static void main(String[] args) throws IncorrectFunctionNameException {
		in = new Scanner(System.in);
		
		Calculator calculator1 = new FlexCalculator(4);
		calculator1.addFunction(new SinFunction());
		calculator1.addFunction(new CosFunction());
		calculator1.addFunction(new LogFunction());
		calculator1.addFunction(new ExponentialFunction());

		
//		Calculator calculator2 = new Calculator(2);
//		calculator2.addFunction(new SinFunction());
//		calculator2.addFunction(new CosFunction());
		
		startCalculator(calculator1);
	}

	private static void startCalculator(Calculator calculator) throws IncorrectFunctionNameException {
		calculator.listMathFunction();

			System.out.println("Please enter the name of the function (or \"x\" for exit):");
			String functionName = in.next();

			if (!Objects.equals(functionName, "Cos") && !Objects.equals(functionName, "Log") && !Objects.equals(functionName, "Sin") && !Objects.equals(functionName, "Exp")) {
				throw new IncorrectFunctionNameException("Incorrect function name: " + functionName);
			}
			

		if(functionName.equalsIgnoreCase("x")) {
			System.out.println("bye!");
			System.exit(0);
		}



		System.out.println("Number of the arguments:");
		try {
			String argumentCount = in.next();
	
		
		double functionArg1 = 0;
		double functionArg2 = 0;
		if(argumentCount.equals("1")){
			System.out.println("Please enter the argument of the function:");
			try {
				functionArg1 = in.nextDouble();
				double result = calculator.doCalculation(functionName, functionArg1);
				System.out.println(functionName + " of " + functionArg1 + " is " + result + "\n");
			}catch(NumberFormatException e){
				System.out.println("Please enter a number, " + e.getMessage());
			}
		}
		else{
			try {
				System.out.println("Please enter the first argument of the function:");
				functionArg1 = in.nextDouble();
				System.out.println("Please enter the second argument of the function:");
				functionArg2 = in.nextDouble();
			}catch(NumberFormatException e) {
				System.out.println("Please enter a number, " + e.getMessage());
			}
			double result = calculator.doCalculation(functionName, functionArg1, functionArg2);
			System.out.println(functionName + " of " + functionArg1 + " and " + functionArg2 + " is " + result + "\n");
			
		}
		}catch(NumberFormatException e){
			System.out.println("Please enter a number, " + e.getMessage());
		}
		startCalculator(calculator);
	}

}
