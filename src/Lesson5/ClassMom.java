package Lesson5;

import java.util.Enumeration;

public abstract class ClassMom {

     public int age;
     protected  String name;
    String firstName;
    private String address;
    public String universityName;

    public ClassMom(String name, String firstName, int age, String universityNomber){
        this.age = age;
        this.name = name;
        this.firstName = firstName;
        this.universityName = universityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public ClassMom() {

    }
}
