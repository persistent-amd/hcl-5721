package spring;

public class ServiceAccount {

    // Public variable: accessible from anywhere
    public String accountHolder;

    // Private variable: accessible only within ServiceAccount
    private double balance;

    // Public constructor: allows object creation from outside
    public ServiceAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Private constructor: prevents direct object creation from outside
    private ServiceAccount() {
        this.accountHolder = "Internal Default";
        this.balance = 0.0;
    }

    // Public method: accessible anywhere
    public void displayAccountDetails() {
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }

    // Private method: helper method, cannot be called from outside
    private void applySecretAudit() {
        System.out.println("Internal audit completed for " + accountHolder);
    }

    // Public getter/setter to demonstrate controlled access to private members
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid balance amount!");
        }
    }
}
