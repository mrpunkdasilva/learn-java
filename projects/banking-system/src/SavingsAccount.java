public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName) {
        super(accountNumber, ownerName);
        this.interestRate = 0.025; // 2.5% interest rate
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }

        if (amount <= getBalance()) {
            double newBalance = getBalance() - amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance: $" + newBalance);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Added interest: $" + interest);
    }
}