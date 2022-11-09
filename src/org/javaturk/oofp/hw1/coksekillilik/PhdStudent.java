package javaturk.oofp.hw1.coksekillilik;

import java.util.Date;

public class PhdStudent extends GraduateStudent {
    private Boolean qualifyingExamToken;

    public PhdStudent(Integer no, String name, Integer year, Date dob, String major, String advisor, String thesis, Boolean qualifyingExamToken) {
        super(no, name, year, dob, major, advisor, thesis);
        this.qualifyingExamToken = qualifyingExamToken;
    }

    @Override
    public void study() {
        System.out.println("Phd student also studying.");
    }

    @Override
    public void register() {
        System.out.println("Phd student also studying.");
    }

    @Override
    public void writeThesis() {
        System.out.println("Phd student wrote thesis.");
    }

    @Override
    public void meetWithAdvisor() {
        System.out.println("Phd student meet with advisor.");
    }

    public void writePaper() {
        System.out.println("Phd student wrote paper");
    }

    public Boolean getQualifyingExamToken() {
        return qualifyingExamToken;
    }

    public void setQualifyingExamToken(Boolean qualifyingExamToken) {
        this.qualifyingExamToken = qualifyingExamToken;
    }
}
