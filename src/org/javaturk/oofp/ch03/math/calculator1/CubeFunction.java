package org.javaturk.oofp.ch03.math.calculator1;

public class CubeFunction implements MathFunction{
    private static final String name = "Cube";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) {
        return arg * arg * arg;
    }
}
