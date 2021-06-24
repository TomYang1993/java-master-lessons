package yxy.tom.bank;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches;
    private String name;

    public Bank(String name) {
        this.branches = new ArrayList<Branch>();
        this.name = name;
    }

    public boolean addBranches(String branchName) {
        if(findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for(int i = 0; i < branches.size(); i++){
            if(branches.get(i).getName().equals(branchName)){
                return branches.get(i);
            }
        }
        return null;
    }

    public boolean addCustomers(String branchName, String customerName, double initial) {
        Branch br = findBranch(branchName);
        if(br != null){
            br.addNewCustomer(customerName, initial);
            return true;
        }
        return false;
    }

    public boolean openAcoount(String branchName, String customerName, double transaction) {
        Branch br = findBranch(branchName);
        if(br != null){
            br.addTransaction(customerName, transaction);
            return true;
        }
        return false;
    }


    public void showCustomersByBranch(String branchName, boolean showTransactions) {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        customers = findBranch(branchName).getCustomers();

        for(int i = 0; i < customers.size(); i++) {
            System.out.println("Customer: " + customers.get(i).getName());
            if(showTransactions){
                ArrayList<Double> transactions = customers.get(i).getTransactions();
                for(int j = 0; j < transactions.size(); j++) {
                    System.out.println("transaction: " + transactions.get(i));
                }
            }
        }
    }
}
