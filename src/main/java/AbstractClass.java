abstract class Animal {

    abstract void sound();  // Abstract method: no body

    void sleep() {           // Non-abstract method: has a body
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Barking");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        d.sleep();
    }
}