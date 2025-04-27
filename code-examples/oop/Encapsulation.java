public class Encapsulation {
    public class BankAccount {
        private String accountNumber;
        private double balance;
        private boolean isLocked;
        
        public BankAccount(String accountNumber) {
            this.accountNumber = accountNumber;
            this.balance = 0.0;
            this.isLocked = false;
        }
        
        // Método público que encapsula a lógica de validação
        public boolean deposit(double amount) {
            if (isLocked || amount <= 0) {
                return false;
            }
            
            this.balance += amount;
            return true;
        }
        
        // Método público que encapsula a lógica de negócio
        public boolean withdraw(double amount) {
            if (isLocked || amount <= 0 || balance < amount) {
                return false;
            }
            
            this.balance -= amount;
            return true;
        }
        
        // Getters controlados
        public double getBalance() {
            return balance;
        }
        
        public String getAccountNumber() {
            return accountNumber;
        }
        
        // Método protegido por senha
        public void lockAccount(String adminPassword) {
            if ("admin123".equals(adminPassword)) {
                this.isLocked = true;
            }
        }
    }
}