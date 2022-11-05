package org.javaturk.oofp.ch03.erp;

public class Consultant {
    String name;
    String university;
    String experiences;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public Consultant(String name, String university, String experiences) {
        this.name = name;
        this.university = university;
        this.experiences = experiences;
    }


}
