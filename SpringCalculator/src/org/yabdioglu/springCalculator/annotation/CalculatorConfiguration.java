package org.yabdioglu.springCalculator.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorConfiguration {
	@Bean
	public CalculatorT1 calculatorT1() {
		CalculatorT1 calculatorT1 = new CalculatorT1(3);
		MathFunction[] mathFunctions = {sinFunction(), cosFunction(), logFunction()};
		calculatorT1.setFunctions(mathFunctions);
		return calculatorT1;
	}
	
	@Bean
	public SinFunction sinFunction() {
		return new SinFunction();
	}
	
	@Bean
	public CosFunction cosFunction() {
		return new CosFunction();
	}
	
	@Bean
	public LogFunction logFunction() {
		return new LogFunction();
	}
	
}	
