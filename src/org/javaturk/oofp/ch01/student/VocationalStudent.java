package org.javaturk.oofp.ch01.student;
import java.util.Date;
public class VocationalStudent extends Student{
	public VocationalStudent(int no, String name, int year, Date date, String major) {
        super(no, name, year, date, major);
    }

    @Override
    public void study() {
        System.out.println("I am a Vocational Student");
    }

    @Override
    public void register() {
        System.out.println("i am register on vocational school");
    }
    
    @Override
    public String toString() {
        return "VocationalStudent{} " + super.toString();
    }

}
