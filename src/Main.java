import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("Welcome to the ATM!");

        // Prompt for user ID and PIN
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        // Validate user ID and PIN
        if (atm.authenticateUser(userId, pin)) {
            System.out.println("Authentication successful!");
            atm.displayMenu();
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }
}