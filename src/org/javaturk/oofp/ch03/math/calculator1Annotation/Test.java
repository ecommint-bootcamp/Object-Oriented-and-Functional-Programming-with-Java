package org.javaturk.oofp.ch03.math.calculator1Annotation;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@ComponentScan(basePackages={"org.javaturk.oofp.ch03.math"})
public class Test {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);

		BeanFactory factory = new AnnotationConfigApplicationContext(Config.class);

		CalculatorT1 calculatorT1 = (CalculatorT1) factory.getBean("calculatorT1");
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
		
		System.out.println("Please enter the name of the function:");
		String functionName = in.next(); 
		if(functionName.equalsIgnoreCase("end"))
			System.exit(0);
		System.out.println("Please enter the argument of the function:");
		double functionArg = in.nextDouble(); 
		double result = calculator.doCalculation(functionName, functionArg);
		System.out.println(functionName + " of " + functionArg + " is " + result + "\n");
		
		startCalculator(calculator);
	}
}
