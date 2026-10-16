package spring;

public class AccessAndObjectCreationDemo {

    public static void main(String[] args) {
        System.out.println("=== 1. Object Creation via Public vs Private Constructor ===");
        
        // Allowed: Calling the public constructor
        ServiceAccount account = new ServiceAccount("Alice", 1500.0);
        System.out.println("Object created successfully using public constructor.");

        // Object Creation Issue:
        // Calling the private no-arg constructor causes a compile-time error:
        // 'ServiceAccount()' has private access in 'spring.ServiceAccount'
        // ServiceAccount invalidAccount = new ServiceAccount(); // COMPILE ERROR!


        System.out.println("\n=== 2. Public vs Private Field Access ===");
        
        // Allowed: Direct access to public field
        account.accountHolder = "Alice Smith";
        System.out.println("Public field 'accountHolder': " + account.accountHolder);

        // Access Issue:
        // Direct access to private field causes a compile-time error:
        // 'balance' has private access in 'spring.ServiceAccount'
        // account.balance = 2000.0; // COMPILE ERROR!
        // System.out.println(account.balance); // COMPILE ERROR!

        // Correct way to access/modify private fields: via public getters/setters
        account.setBalance(2000.0);
        System.out.println("Private field accessed via public getter: $" + account.getBalance());


        System.out.println("\n=== 3. Public vs Private Method Access ===");

        // Allowed: Calling public method
        account.displayAccountDetails();

        // Access Issue:
        // Calling private method causes a compile-time error:
        // 'applySecretAudit()' has private access in 'spring.ServiceAccount'
        // account.applySecretAudit(); // COMPILE ERROR!
    }
}
