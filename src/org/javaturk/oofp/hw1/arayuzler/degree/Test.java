package javaturk.oofp.hw1.arayuzler.degree;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bir sayı giriniz.");
        Integer value = scanner.nextInt();
        Celcius celcius = new Celcius();
        Fahrenheit fahrenheit = new Fahrenheit();
        Kelvin kelvin = new Kelvin();
        System.out.println(celcius.calculate(value) + " " + "degree");
        System.out.println(kelvin.calculate(value) + " " + "kelvin");
        System.out.println(fahrenheit.calculate(value) + " " + "fahrenheit");
    }
}
