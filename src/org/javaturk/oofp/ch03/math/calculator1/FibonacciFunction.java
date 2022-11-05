package org.javaturk.oofp.ch03.math.calculator1;

public class FibonacciFunction implements MathFunction{

    @Override
    public String getName() {
        return "Fibonacci Function";
    }

    @Override
    public double calculate(double arg) {
        return getFibonacciValue(arg);
    }

    private double getFibonacciValue(double arg){

        double firstValue = 0;
        double secondValue = 1;
        double y = 0;

        for(int i=2; i<arg; i++){
            y += firstValue + secondValue;
            firstValue = secondValue;
            secondValue = y;
        }
        return y;
    }
}
