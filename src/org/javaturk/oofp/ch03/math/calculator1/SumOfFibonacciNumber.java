package javaturk.oofp.ch03.math.calculator1;

public class SumOfFibonacciNumber implements MathFunction {

    private static String name = "Fib";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double calculate(double arg) {
        return (double)sumOfFibonacciNumber((int)arg);
    }

    public int sumOfFibonacciNumber(int arg){
        int sum=0,a=0,b=1,c=0;
        for(int i=1;i<arg;i++){
            c=a+b;
            a=b;
            b=c;
            sum=sum+c;
        }
        return sum;
    }
}
