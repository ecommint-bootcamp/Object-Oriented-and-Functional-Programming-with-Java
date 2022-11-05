/*----------------------------------------------------------------------
	FILE        : RegistrationOffice.java
	AUTHOR      : Furkan Zengin
	LAST UPDATE : 10.31.2022

	RegistrationOffice class that handle the registration operations of university.
-----------------------------------------------------------------------*/
package org.javaturk.oofp.hw1.university;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RegistrationOffice {
    private final Random r;

    RegistrationOffice() {
      r = new Random();
    }

    RegistrationOffice(Random r) {
        this.r = r;
    }

    public Student getAStudent() {
        int typeOfStudent = r.nextInt(4);
        switch (typeOfStudent) {
            case 0 -> {
                return new UndergraduateStudent(r.nextInt(10000), "Erdem Safkan", 2022, new Date(r.nextInt(1990, 2000), Calendar.APRIL, r.nextInt(29) + 1),
                        "Electronic and Communication Engineering", " " );
            }
            case 1 -> {
                return new PhdStudent(r.nextInt(10000), "Kamil San", 2022,new Date(r.nextInt(1990, 2000), Calendar.AUGUST, r.nextInt(29) + 1),
                        "Software Engineering", "Müştak Erhan Yalçın", "Electromagnetic Fields", false);
            }

            case 2 -> {
               return new MasterStudent(r.nextInt(10000), "Beyza Zengin", 2022,new Date(r.nextInt(1990, 2000), Calendar.FEBRUARY, r.nextInt(29) + 1),
                       "Mechanical Engineering", "Güneş Karabulut Kurt", "Electromagnetic Fields");
            }

            case 3 -> {
                return new VocationalStudent(r.nextInt(10000), "Melike Imre", 2022, new Date(r.nextInt(1990, 2000), Calendar.DECEMBER, r.nextInt(29) + 1),
                        "Aerospace Engineering");
            }

            default -> {
                return new UndergraduateStudent(r.nextInt(10000), "Furkan Zengin", 2022, new Date(r.nextInt(1990, 2000), Calendar.JUNE, r.nextInt(29) + 1),
                        "Electronic and Communication Engineering", " " );
            }
            }
        }


    public void registerStudent(Student student) {
        if(student == null)
            return;

        if(student instanceof UndergraduateStudent u){
            System.out.println(u.getClass().getName());
            u.register();
            System.out.println("------------------");
        }
        else if (student instanceof PhdStudent p){
            System.out.println(p.getClass().getName());
            p.register();
            System.out.println("------------------");

        }
        else if (student instanceof MasterStudent m){
            System.out.println(m.getClass().getName());
            m.register();
            System.out.println("------------------");
        }

        else if(student instanceof VocationalStudent v) {
            System.out.println(v.getClass().getName());
            v.register();
            System.out.println("------------------");        }
    }

    public static void main(String[] args) {
        RegistrationOffice rf = new RegistrationOffice();
        for(int i = 0; i < 5; ++i){
            rf.registerStudent(rf.getAStudent());
        }
    }

}
