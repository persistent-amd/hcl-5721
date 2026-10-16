package spring;

public class SingleEmployee {

    static final SingleEmployee obj = new SingleEmployee();

    // rule 1: make constructor private
    private SingleEmployee(){

    }

    public static SingleEmployee makeInstance(){
        return obj;
    }

    public String getter(){
        return "Hi I am Java";
    }
}