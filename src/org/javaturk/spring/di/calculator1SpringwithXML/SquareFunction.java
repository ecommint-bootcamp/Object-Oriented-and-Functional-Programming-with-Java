package org.javaturk.spring.di.calculator1SpringwithXML;

public class SquareFunction implements MathFunction{

    private static String name = "Square";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) {
        return Math.pow(arg,2);
    }
}
