package calculator_ann;

import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;

@org.springframework.context.annotation.Configuration
//@ComponentScan(basePackages = "HomeWorkSpring.Annotation")
public class Configuration {

    @Bean
    public CalculatorT1 calculatorT1() {
        final CalculatorT1 calculatorT1 = new CalculatorT1(5);
        MathFunction[] functions = {cosFunction(), sinFunction(), factorialFunction(), logFunction(), squaredFunction()};
        calculatorT1.setFunctions(functions);
        return calculatorT1;
    }

    @Bean
    public MathFunction factorialFunction() {
        return new FactorialFunction();
    }

    @Bean
    public MathFunction cosFunction() {
        return new CosFunction();
    }

    @Bean
    public MathFunction sinFunction() {
        return new SinFunction();
    }

    @Bean
    public MathFunction logFunction() {
        return new LogFunction();
    }

    @Bean
    public MathFunction squaredFunction() {
        return new SquaredFunction();
    }

}
