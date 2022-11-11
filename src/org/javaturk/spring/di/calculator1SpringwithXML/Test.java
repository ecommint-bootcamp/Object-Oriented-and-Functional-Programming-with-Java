package org.javaturk.spring.di.calculator1SpringwithXML;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Test {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		BeanFactory factory = new ClassPathXmlApplicationContext(
				"org/javaturk/spring/di/calculator1SpringwithXML/resources/beans.xml");
		CalculatorT1 calculatorT1=(CalculatorT1) factory.getBean("calculator");


		
		/*CalculatorT1 calculator1 = new CalculatorT1(6);
		calculator1.addFunction(new SinFunction());
		calculator1.addFunction(new CosFunction());
		calculator1.addFunction(new CubeFunction());
		calculator1.addFunction(new SquareFunction());
		calculator1.addFunction(new SquareRootFunction());
		calculator1.addFunction(new FibonacciFunction());*/
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
		
		startCalculator(calculatorT1);
	}

	private static void startCalculator(CalculatorT1 calculator) {
		calculator.listMathFunction();

		//System.out.println("Please enter the name of the function:");
		//String functionName = in.next();
		//if(functionName.equalsIgnoreCase("end"))
		//	System.exit(0);
		//System.out.println("Please enter the argument of the function:");
		//double functionArg = in.nextDouble();
		double result = calculator.doCalculation("Cos", 90);
		System.out.println(result);
		//System.out.println(functionName + " of " + functionArg + " is " + result + "\n");

		//startCalculator(calculator);
	}
}
