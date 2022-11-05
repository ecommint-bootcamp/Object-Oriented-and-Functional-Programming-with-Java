package org.javaturk.oofp.ch03.math.calculator1;

public class CubeFunction implements MathFunction{
    @Override
    public String getName() {
        return "Exponentiation Function";
    }

    @Override
    public double calculate(double arg) {
        return Math.pow(arg, 3);
    }
}
