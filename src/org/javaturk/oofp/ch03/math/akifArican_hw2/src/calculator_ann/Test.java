package calculator_ann;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Test {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        BeanFactory beanFactory = new AnnotationConfigApplicationContext(Configuration.class);

        CalculatorT1 calculatorT1 = (CalculatorT1) beanFactory.getBean("calculatorT1");

        startCalculator(calculatorT1);

    }

    private static void startCalculator(CalculatorT1 calculator) {
        calculator.listMathFunction();
        System.out.println("Please enter the name of the function:");
        String functionName = in.next();
        if (functionName.equalsIgnoreCase("end"))
            System.exit(0);
        System.out.println("Please enter the argument of the function:");
        double functionArg = in.nextDouble();
        double result = calculator.doCalculation(functionName, functionArg);
        System.out.println(functionName + " of " + functionArg + " is " + result + "\n");

        startCalculator(calculator);
    }
}