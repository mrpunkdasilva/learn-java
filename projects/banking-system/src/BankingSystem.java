public class BankingSystem {
    public static void main(String[] args) {
        // Create a new bank
        Bank bank = new Bank();

        // Create accounts
        CheckingAccount checking = new CheckingAccount("CH001", "John Doe");
        SavingsAccount savings = new SavingsAccount("SA001", "Jane Doe");

        // Add accounts to bank
        bank.addAccount(checking);
        bank.addAccount(savings);

        // Perform operations
        checking.deposit(1000);
        checking.withdraw(1500); // Will fail
        checking.withdraw(1050); // Will work due to overdraft

        savings.deposit(2000);
        savings.withdraw(500);
        savings.addInterest();

        // List all accounts
        bank.listAccounts();
    }
}