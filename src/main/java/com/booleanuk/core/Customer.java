package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    Savings savings;
    Current current;
    enum Branch {
        OSLO, BERGEN, HARDANGER
    }
    Customer.Branch branch;


    public Customer() {
        this.branch = Branch.BERGEN;
    }

    public Boolean setBranch(Customer.Branch branch) {
        this.branch = branch;
        return true;
    }
    public boolean overdraft(Float amount){
        if (amount < current.getBalance()+200){
            //må legge til at dette er ekstraordinert`?
            current.withdrawAmount(amount);
            return true;
        }
        return false;
    }

    public boolean createRequests(Float amount){
        if (amount < current.getBalance()+400.00f){
            //må legge til at dette er ekstraordinert`?

            return current.addRequest(amount);

        }

        return false;
    }

    public boolean approveRequests(Float requests, boolean approved){
        if (current.findAmount(requests) != -999.40f) {
            if (approved) {
                current.withdrawAmount(requests);
                return true;
            }
            current.removeRequest(requests);
        }

        return false;
    }

    //Should I have this as boolean or as object as return? when I tried with a object it did not pass the test.
    public boolean createAccount(String type){

        if (type.equalsIgnoreCase("SAVINGS")){

            savings = new Savings(new ArrayList<Transaction>());
            return true;
        }
        if (type.equalsIgnoreCase("CURRENT")){

            current = new Current(new ArrayList<Transaction>());
            return true;
        }

        return false;
    }
    public Float withdrawFunds(Float amount, String type){
        if (type.equalsIgnoreCase("SAVINGS")){
            if (amount <= savings.getBalance())
                return savings.withdrawAmount(amount);
        }
        if (type.equalsIgnoreCase("CURRENT")){
            if (amount <= current.getBalance())
                return current.withdrawAmount(amount);

        }
        return -1.00f;
    }
    //it does not work with giving account as a parameter? I need to do it with the variables for customer?
    public Float depositFunds(Float amount, String type){

        if (type.equalsIgnoreCase("SAVINGS")){
            return savings.addAmount(amount);
        }
        if (type.equalsIgnoreCase("CURRENT")){
            return current.addAmount(amount);

        }


        return -1.00f;
    }
    //I am not sure how to test it wihout true or false

    public boolean generateBankStatement(String type){

        if (type.equalsIgnoreCase("SAVINGS")) {

            if (savings.transactions.size() > 0){
                System.out.println("\n ---- BANK STATEMENT ---- \n\tFor Savings account");

                return savings.generateBankStatement();
            }
        }
        if (type.equalsIgnoreCase("CURRENT")){
            if (current.transactions.size()>0) {
                System.out.println("\n ---- BANK STATEMENT ---- \n\tFor Current account");

                return current.generateBankStatement();
            }

        }

        return false;
    }
    public Float getBalanceHardWay(String type){

        if (type.equalsIgnoreCase("SAVINGS")) {

            if (savings.transactions.size() > 0){

                return savings.getBalanceHardWay();
            }
        }
        if (type.equalsIgnoreCase("CURRENT")){
            if (current.transactions.size()>0) {
                System.out.println("\n ---- BANK STATEMENT ---- \n\tFor Current account");

                return current.getBalanceHardWay();
            }

        }
        return -1.00f;

    }
}


