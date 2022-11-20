package javaturk.oofp.ch03.math.calculator1;

public class SquaredFunction implements MathFunction {

    private static String name = "Squared";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg1) throws ExceptionHandling {
        try {
            return Math.sqrt(arg1);
        } catch (Exception e) {
            throw new ExceptionHandling("Wrong data type. Check your input.");
        }
    }
}
