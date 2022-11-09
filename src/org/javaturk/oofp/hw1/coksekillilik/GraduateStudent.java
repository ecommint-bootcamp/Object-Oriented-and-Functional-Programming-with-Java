package javaturk.oofp.hw1.coksekillilik;

import java.util.Date;

public class GraduateStudent extends Student {

    private String advisor;
    private String thesis;

    public GraduateStudent(Integer no, String name, Integer year, Date dob, String major, String advisor, String thesis) {
        super(no, name, year, dob, major);
        this.advisor = advisor;
        this.thesis = thesis;
    }

    @Override
    public void study() {

    }

    @Override
    public void register() {

    }

    public void writeThesis() {

    }

    public void meetWithAdvisor() {

    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }
}
