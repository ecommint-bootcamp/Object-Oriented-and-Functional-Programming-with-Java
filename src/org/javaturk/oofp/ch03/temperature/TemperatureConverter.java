package org.javaturk.oofp.ch03.temperature;

public class TemperatureConverter implements Converter{
    private int tempUnitCount;
    private TemperatureUnit[] temperatureUnits;
    private int currentCount = 0;

    public TemperatureConverter(int tempUnitCount) {
        this.tempUnitCount = tempUnitCount;
        temperatureUnits = new TemperatureUnit[tempUnitCount];
    }

    @Override
    public double convert(String unit1, String unit2) {
        return 0;
    }

    @Override
    public void addUnit(TemperatureUnit unit) {
        temperatureUnits[currentCount]= unit;
        currentCount++;
    }

    @Override
    public void listUnits() {
        System.out.println("Units to Convert:");
        for (TemperatureUnit tempUnit : temperatureUnits)
            System.out.println(tempUnit.getName());
    }
}
