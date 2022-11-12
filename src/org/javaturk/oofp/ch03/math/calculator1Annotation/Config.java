package org.javaturk.oofp.ch03.math.calculator1Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean()
    public CalculatorT1 calculatorT1() {
        final CalculatorT1 calculatorT1 = new CalculatorT1(5);
        MathFunction[] functions = { cosFunction(), factorialFunction(), logFunction(), sinFunction(), squaredFunction() };
        calculatorT1.setFunction(functions);
        return calculatorT1;
    }

    @Bean
    public MathFunction cosFunction() {
        return new CosFunction();
    }

    @Bean
    public MathFunction factorialFunction() {
        return new FactorialFunction();
    }

    @Bean
    public MathFunction logFunction() {
        return new LogFunction();
    }

    @Bean
    public MathFunction sinFunction() {
        return new SinFunction();
    }

    @Bean
    public MathFunction squaredFunction() {
        return new SquaredFunction();
    }
}