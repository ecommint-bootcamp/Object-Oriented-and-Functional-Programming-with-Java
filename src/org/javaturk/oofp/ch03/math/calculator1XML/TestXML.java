package org.javaturk.oofp.ch03.math.calculator1XML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestXML {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		ApplicationContext context = new ClassPathXmlApplicationContext("org/javaturk/oofp/ch03/math/calculator1XML/resources/beans.xml");
		Calculator calculator = (Calculator) context.getBean("calculator");

    	calculator.addFunction((SinFunction)context.getBean("sinfunction"));
		calculator.addFunction((CosFunction)context.getBean("cosfunction"));
		calculator.addFunction((SquaredFunction)context.getBean("squaredfunction"));
		calculator.addFunction((SquareFunction)context.getBean("squarefunction"));
		calculator.addFunction((CubeFunction)context.getBean("cubefunction"));//
		calculator.addFunction((SumOfFibonacciFunction)context.getBean("fibonaccifunction"));
		calculator.addFunction((FactorialFunction)context.getBean("factorialfunction"));
		calculator.addFunction((LogFunction)context.getBean("logfunction"));


		
		startCalculator((CalculatorT1) calculator);

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
