package atm_project;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetails {
    private int acc;
    private int pin;
    private int balance = 0;
    private List<String> transactions = new ArrayList<>();

    public CustomerDetails(int acc, int pin) {
        this.acc = acc;
        this.pin = pin;
    }

    public int getAcc() {
        return acc;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        this.balance = amount;
    }

    public void addTransaction(String txn) {
        transactions.add(txn);
        if (transactions.size() > 5) {
            transactions.remove(0);
        }
    }

    public List<String> getTransactions() {
        return transactions;
    }
}
