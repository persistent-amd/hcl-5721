public class StaticMethodVariables {
    static String college = "ABES";  // Static member
    String name = "Ad";              // Instance member

    static void showCollege() {      // Static method
        System.out.println(college);
    }

    void showName() {                // Instance method
        System.out.println(name);
    }

    public static void main(String[] args) {
        StaticMethodVariables.showCollege();       // No object needed

        StaticMethodVariables s = new StaticMethodVariables();   // Create object
        s.showName();                // Object needed
    }
}