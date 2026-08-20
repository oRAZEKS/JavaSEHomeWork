package Lesson5;

public class NomberUniversity extends ClassMom {

    public void hello() {
        System.out.println("Hi, my name is " + name);
    }

    @Override
    public String getAddress() {
        return "My address: " + super.getAddress();
    }
}
