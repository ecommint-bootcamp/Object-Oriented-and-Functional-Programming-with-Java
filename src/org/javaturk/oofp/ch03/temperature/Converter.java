package org.javaturk.oofp.ch03.temperature;

public interface Converter {

    double convert(String unit1,String unit2);

     void addUnit(TemperatureUnit unit);

    void listUnits();
}
