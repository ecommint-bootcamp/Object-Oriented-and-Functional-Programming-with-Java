package org.javaturk.oofp.ch03.math.calculator1;


public class FibonacciFunction implements MathFunction {

    private static String name = "Fibonacci";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) {
        if (arg<= 0)
            return 0;

        int[] fibonacci =new int[(int)arg+1];
        fibonacci[0] = 0; fibonacci[1] = 1;

        int sum = fibonacci[0] + fibonacci[1];

        for (int i=2; i<=arg; i++)
        {
            fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
            sum += fibonacci[i];
        }

        return sum;
    }
}
