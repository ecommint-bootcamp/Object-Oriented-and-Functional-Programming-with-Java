package org.javaturk.oofp.ch03.temperatureConversions;

public class Template {
	
	private Converter convert;

    public Template(Converter convert) {
        this.convert = convert;
    }

    public void calculate(int temp) {
        convert.convert(temp);
    }

}
