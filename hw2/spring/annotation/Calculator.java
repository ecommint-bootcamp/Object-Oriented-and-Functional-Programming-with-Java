package annotation;

public interface Calculator {
	
	public void AddFunction(MathFunction function);
	
	public void listMathFunction();
	
	public double doCalculation(String functionName, double arg);

	public void setFunction(MathFunction[] functions);
}