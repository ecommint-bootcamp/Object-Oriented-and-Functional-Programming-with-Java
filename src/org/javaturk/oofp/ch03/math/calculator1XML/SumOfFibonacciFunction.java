package org.javaturk.oofp.ch03.math.calculator1XML;

public class SumOfFibonacciFunction implements MathFunction{

    private static final String name = "Fibonacci";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) throws FunctionArgumentValueException {
        if(arg <= 0) {
            throw new FunctionArgumentValueException();
        }
        return calculateSumOfFibonacci((int)arg);
    }

    private int calculateSumOfFibonacci(int count){
        if(count <= 0)
            return 0;
        int sum = 0;
        int [] fibonacci = getFibonacci(count);

        for (int i : fibonacci) {

            sum += i;
        }

        return sum;
    }


    private int[] getFibonacci(int count){
        int [] fibonacciNumbers = new int[count];
        if (count == 1){
            return new int[]{1};
        }

        if (count == 2){
            return new int[]{1, 1};
        }

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;
        for(int i = 2; i < fibonacciNumbers.length; ++i){
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }
        return fibonacciNumbers;
    }

    private void displayFibonacciNumbers(int count){
        int [] fibonaccies = getFibonacci(count);
        for (int val : fibonaccies) {
            System.out.println(val + " ");
        }
    }



}
