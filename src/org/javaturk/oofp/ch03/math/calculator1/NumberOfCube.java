package javaturk.oofp.ch03.math.calculator1;

public class NumberOfCube implements MathFunction {

    private static String name = "numberOfCube";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) throws ExceptionHandling{
        try {
            return (double) numberOfSquare((int) arg);
        }

        catch (Exception e){
            throw new ExceptionHandling("Wrong data type. Check your input.");
        }

    }

    private int numberOfSquare(int arg) {
        return arg * arg * arg;
    }
}

