package org.javaturk.oofp.ch03.temperature;

import java.util.Scanner;

public class Test {
    private static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);

        Converter converter1 = new TemperatureConverter(in.nextInt());
        converter1.addUnit(new Celsius());
        converter1.addUnit(new Kelvin());
        converter1.addUnit(new Fahrenheit());
        startConverter(converter1);

    }

    private static void startConverter(Converter converter) {
        converter.listUnits();
        System.out.println("Please first , enter the name of the unit,then the unit you wish to convert to (or \"x\" for exit):");
        String unitName1=in.nextLine();
        String unitName2=in.nextLine();
        if(unitName1.equalsIgnoreCase("x") || unitName2.equalsIgnoreCase("x")) {
            System.out.println("bye!");
            System.exit(0);
        }

            System.out.println("Please enter the temperature:");
            double temperature = in.nextDouble();
            double result = converter.convert(unitName1,unitName2);
            System.out.println(temperature +  unitName1  + " is " + result + unitName2 + "\n");

        startConverter(converter);
    }
}
