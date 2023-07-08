public class User {
    private int userId;
    private int pin;
    private Account account;

    public User(int userId, int pin) {
        this.userId = userId;
        this.pin = pin;
        this.account = new Account(0.0); // Initialize account balance as 0.0
    }

    public int getUserId() {
        return userId;
    }

    public int getPin() {
        return pin;
    }

    public Account getAccount() {
        return account;
    }
}
