package atm_project;

import java.util.ArrayList;
import java.util.List;

public class BankData {
    private List<CustomerDetails> customers = new ArrayList<>();

    public BankData() {
        customers.add(new CustomerDetails(101, 1));
        customers.add(new CustomerDetails(102, 2));
        customers.add(new CustomerDetails(103, 3));
    }

    public CustomerDetails verifyLogin(int acc, int pin) {
        for (CustomerDetails c : customers) {
            if (c.getAcc() == acc && c.getPin() == pin) {
                return c;
            }
        }
        return null;
    }
}
