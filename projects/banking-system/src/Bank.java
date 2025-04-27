import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account created successfully: " + account.getAccountNumber());
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void listAccounts() {
        System.out.println("\nBank Accounts:");
        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + 
                             ", Owner: " + account.getOwnerName() + 
                             ", Balance: $" + account.getBalance());
        }
    }
}