package javaturk.oofp.hw1.coksekillilik;

import java.util.Date;

public class UndergraduateStudent extends Student {
    private String minor;

    public UndergraduateStudent(Integer no, String name, Integer year, Date dob, String major,String minor) {
        super(no, name, year, dob, major);
        this.minor=minor;
    }

    @Override
    public void study(){
        System.out.println("Undergraduate-student also studying.");
    }
    @Override
    public void register(){
        System.out.println("Undergraduate-student registered.");
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    @Override
    public String toString() {
        return "UndergraduateStudent{" +
                "minor='" + minor + '\'' +
                '}';
    }
}
