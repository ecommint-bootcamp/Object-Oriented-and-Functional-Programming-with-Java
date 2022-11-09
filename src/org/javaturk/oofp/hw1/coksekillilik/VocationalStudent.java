package javaturk.oofp.hw1.coksekillilik;

import java.util.Date;

public class VocationalStudent extends Student {


    public VocationalStudent(Integer no, String name, Integer year, Date dob, String major) {
        super(no, name, year, dob, major);
    }

    public void study() {
        System.out.println("Vocational student also studying.");
    }

    public void register() {
        System.out.println("Undergraduate-student registered.");
    }



    @Override
    public String toString() {
        return "VocationalStudent{}";
    }
}
