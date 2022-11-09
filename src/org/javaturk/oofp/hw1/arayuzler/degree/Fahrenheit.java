package javaturk.oofp.hw1.arayuzler.degree;

public class Fahrenheit implements Calculate {

    public Double calculate(Integer value) {
        Double fahrenheit = (double) (value * 1.8 + 32);
        return fahrenheit;
    }
}
