import java.util.Scanner;

public class ATM {
    private User currentUser;
    private User user2;
    private TransactionHistory transactionHistory;

    public ATM() {
        transactionHistory = new TransactionHistory();
        // Initialize user data
        // Add code here to load user data from a file or database
    }

    public boolean authenticateUser(int userId, int pin) {
        // Add code here to validate the user ID and PIN
        // and set the currentUser if authentication is successful
        currentUser = new User(userId, pin);
        return true; // Placeholder
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ATM Menu");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayTransactionHistory();
                    break;
                case 2:
                    performWithdraw();
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performTransfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void displayTransactionHistory() {
        transactionHistory.displayTransactionHistory();
    }

    private void performWithdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        // Check if the amount is valid
        if (amount > 0) {
            Account userAccount = currentUser.getAccount();
            if (userAccount.getBalance() >= amount) {
                userAccount.withdraw(amount);
                String transaction = "Withdraw: -$" + amount;
                transactionHistory.addTransaction(transaction);
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void performDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        // Check if the amount is valid
        if (amount > 0) {
            Account userAccount = currentUser.getAccount();
            userAccount.deposit(amount);
            String transaction = "Deposit: +$" + amount;
            transactionHistory.addTransaction(transaction);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void performTransfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recipient's user ID: ");
        int recipientId = scanner.nextInt();

        // Check if the recipient's user ID is valid
        // Add code here to validate the recipient's user ID

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        // Check if the amount is valid
        if (amount > 0) {
            Account userAccount = currentUser.getAccount();
            Account recipientAccount =  user2.getAccount();

            if (userAccount.getBalance() >= amount) {
                userAccount.transfer(amount, recipientAccount);
                String transaction = "Transfer: -$" + amount + " to " + recipientId;
                transactionHistory.addTransaction(transaction);
                System.out.println("Transfer successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid amount.");
        }
    }
}
