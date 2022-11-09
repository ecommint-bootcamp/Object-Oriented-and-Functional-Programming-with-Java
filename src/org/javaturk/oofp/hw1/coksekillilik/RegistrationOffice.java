package javaturk.oofp.hw1.coksekillilik;

import java.util.Date;
import java.util.Random;

public class RegistrationOffice {

    public Student getAStudent() {

        Student student=null;
        Integer s = new Random().nextInt(5) + 1;

        switch (s) {
            case 1:
                student = new GraduateStudent(1, "Emre", 1994, new Date(1994, 6, 26), "Electronic","Emre","Algorithma");
                break;
            case 2:
                student = new MasterStudent(1, "Emre", 1994, new Date(1994, 6, 26), "Electronic","Emre","Fluid Dynamic");
                break;
            case 3:
                student = new PhdStudent(1, "Emre", 1994, new Date(1994, 6, 26), "Electronic","Emre","Emre",true);
                break;
            case 4:
                student = new VocationalStudent(1, "Emre", 1994, new Date(1994, 6, 26), "Electronic");
                break;
            case 5:
                student = new UndergraduateStudent(1, "Emre", 1994, new Date(1994, 6, 26), "Electronic","Transistor");
                break;
        }
        return student;
    }

    public void registerStudent(Student student) {
        try {
            if (student instanceof UndergraduateStudent undergraduateStudent) {
                System.out.println(undergraduateStudent.getClass().getName());
                undergraduateStudent.register();
            } else if (student instanceof VocationalStudent vocationalStudent) {
                System.out.println(vocationalStudent.getClass().getName());
                vocationalStudent.register();
            } else if (student instanceof GraduateStudent graduateStudent) {
                if (student instanceof PhdStudent phdStudent) {
                    System.out.println(phdStudent.getClass().getName());
                    phdStudent.register();
                } else if (student instanceof MasterStudent masterStudent) {
                    System.out.println(masterStudent.getClass().getName());
                    masterStudent.register();
                } else
                    System.out.println((graduateStudent.getClass().getName()));
                graduateStudent.register();
            }
            student.register();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
