public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void transfer(double amount, Account recipientAccount) {
        balance -= amount;
        recipientAccount.deposit(amount);
    }
}
