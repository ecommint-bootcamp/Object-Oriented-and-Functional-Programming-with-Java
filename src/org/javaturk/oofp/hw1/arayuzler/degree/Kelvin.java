package javaturk.oofp.hw1.arayuzler.degree;

public class Kelvin implements Calculate {

    public Double calculate(Integer value) {
        Double kelvin = (double) (value + 274.15);
        return kelvin;
    }
}
