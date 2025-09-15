import java.util.*;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCurrent balance: $" + atm.getBalance());
            System.out.print("Enter amount to withdraw (0 to exit): ");
            int amount = scanner.nextInt();

            if (amount == 0) {
                break;
            }

            atm.withdraw(amount);
        }

        scanner.close();
        System.out.println("Thank you for using the ATM!");
    }
}