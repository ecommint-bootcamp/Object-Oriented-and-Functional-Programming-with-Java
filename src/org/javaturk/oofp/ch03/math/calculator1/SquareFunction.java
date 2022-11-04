package org.javaturk.oofp.ch03.math.calculator1;

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
