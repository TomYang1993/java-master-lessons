package yxy.tom.bank;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers;
    private String name;

    public Branch(String name) {
        this.customers = new ArrayList<Customer>();
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    public boolean addNewCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            customers.add(new Customer(initialAmount, customerName));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double transaction) {
        if(findCustomer(customerName) != null) {
            customers.add(findCustomer(customerName));
            findCustomer(customerName).addTransactions((transaction));
            return true;
        }else{
            return false;
        }
    }

    private Customer findCustomer(String customerName) {
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getName().equals(customerName)){
                return customers.get(i);
            }
        }
        return null;
    }
}
