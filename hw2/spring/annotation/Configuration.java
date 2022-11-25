package annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring")
public class IocConfig {
	@Bean()
	public CalculatorT1 calculatorT1() {
		final CalculatorT1 calculatorT1 = new CalculatorT1(2);
		MathFunction[] functions = { sinFunction(), cosFunction() };
		calculatorT1.setFunction(functions);
		return calculatorT1;
	}

	@Bean
	public MathFunction sinFunction() {
		return new SinFunction();
	}

	@Bean
	public MathFunction cosFunction() {
		return new CosFunction();
	}
}