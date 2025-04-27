public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName) {
        super(accountNumber, ownerName);
        this.overdraftLimit = 100.0;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }

        double maxWithdrawal = getBalance() + overdraftLimit;
        if (amount <= maxWithdrawal) {
            double newBalance = getBalance() - amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New balance: $" + newBalance);
            return true;
        } else {
            System.out.println("Insufficient funds (including overdraft)");
            return false;
        }
    }
}