package javaturk.oofp.ch03.math.calculator1;

public class NumberOfSquare implements MathFunction {

    private static String name = "numberOfSquare";
    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) {
        return (double) numberOfSquare((int) arg);
    }

    private int numberOfSquare(int arg) {
        return arg * arg;
    }
}
