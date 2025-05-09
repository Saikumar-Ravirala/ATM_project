package atm_project;

import java.util.Scanner;

public class BackGroundOperation {

    public CustomerDetails credChecker(Scanner scanner) {
        BankData bank = new BankData();
        CustomerDetails loggedInCustomer = null;

        while (loggedInCustomer == null) {
            System.out.print("Enter Account Number: ");
            int acc = scanner.nextInt();
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();

            loggedInCustomer = bank.verifyLogin(acc, pin);
            if (loggedInCustomer != null) {
                System.out.println("Login successful. Welcome, Account: " + loggedInCustomer.getAcc());
            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }

        return loggedInCustomer;
    }

    public void menu(CustomerDetails c, Scanner sc) {
        while (true) {
            System.out.println("\n__MENU__");
            System.out.println("1. VIEW BALANCE");
            System.out.println("2. WITHDRAW");
            System.out.println("3. DEPOSIT");
            System.out.println("4. MINI STATEMENT");
            System.out.println("5. LOGOUT");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> viewBalance(c);
                case 2 -> withDraw(c, sc);
                case 3 -> deposit(c, sc);
                case 4 -> showMiniStatement(c);
                case 5 -> {
                    System.out.println("Logged out successfully.\n");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewBalance(CustomerDetails c) {
        System.out.println("Your current balance is: Rs " + c.getBalance());
    }

    private void deposit(CustomerDetails c, Scanner sc) {
        System.out.print("Enter the amount to deposit: ");
        int amount = sc.nextInt();
        c.setBalance(c.getBalance() + amount);
        c.addTransaction("Deposited Rs " + amount);
        System.out.println("Deposit successful. Current balance: Rs " + c.getBalance());
    }

    private void withDraw(CustomerDetails c, Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        int amount = sc.nextInt();

        if (amount <= c.getBalance()) {
            c.setBalance(c.getBalance() - amount);
            c.addTransaction("Withdrew Rs " + amount);
            System.out.println("Withdrawn Rs " + amount + ". Current balance: Rs " + c.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void showMiniStatement(CustomerDetails c) {
        System.out.println("----- Mini Statement -----");
        for (String txn : c.getTransactions()) {
            System.out.println(txn);
        }
        System.out.println("--------------------------");
    }
}
