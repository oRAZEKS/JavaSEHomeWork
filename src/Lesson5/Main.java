package Lesson5;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        University university = new University(){};
        university.universityName = "MGY";

       NomberUniversity nomberUniversity = new NomberUniversity(){
       };

        nomberUniversity.name = "Sam";
        nomberUniversity.setAddress("Moskov");
        nomberUniversity.age = 19;



       nomberUniversity.hello();
       university.NameUN();
    }
}
