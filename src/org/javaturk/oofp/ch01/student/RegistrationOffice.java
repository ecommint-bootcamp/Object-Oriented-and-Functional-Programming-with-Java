package org.javaturk.oofp.ch01.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationOffice {
    public RegistrationOffice(){

    }

    public Student getAStudent() throws ParseException {
        Student student=null;
        int i = (int) (6 * Math.random());


        switch (i) {
            case 0 -> student = new Student("Özlem", 2016, createDate("24/05/1999"), "Computer Science");
            case 1 -> student = new UndergraduateStudent("Aslı", 2019, createDate("13/02/2001"), "Industrial Engineering", "Business");
            case 2 -> student = new VocationalStudent("Mehmet", 2020, createDate("30/09/1998"), "Machine Technician");
            case 3 -> student = new GraduateStudent("Ali", 2015, createDate("23/11/1995"), "International Relations", "Cem Öz", "Şanghay işbirliği örgütü: Genel görünüm ve Orta Asya ");
            case 4 -> student = new MasterStudent("Gözde", 2019, createDate("03/12/1995"), "Mathematics", "Sevim Gürler", "Contact Structures and Legendrian Links");
            case 5 -> student = new PhdStudent("Cüneyt", 2020, createDate("03/12/1994"), "Computer Science", "Uğur Ay", "Modeling document classification to automate mental health diagnosis", false);
        }
        return student;
    }

    public void registerStudent(Student student){
     if(student instanceof UndergraduateStudent){
         student.register();
     }else if(student instanceof GraduateStudent){
         if(student instanceof MasterStudent){
                student.register();
         }else if(student instanceof PhdStudent){
             student.register();
         }else{
             student.register();
         }
     } else if(student instanceof VocationalStudent){
         student.register();
     }else{
         if(student != null){
             student.register();
         }

     }


    }

    public Date createDate(String date) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        return date1;
    }
}
