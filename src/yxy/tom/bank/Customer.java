package yxy.tom.bank;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions;
    private String name;

    public Customer(double initialAmount, String name) {
        this.transactions = new ArrayList<Double>();
        this.addTransactions(initialAmount);
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }

    public void addTransactions(double transaction) {
        transactions.add(transaction);
    }
}
