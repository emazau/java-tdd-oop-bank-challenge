package com.booleanuk.core;

import java.util.ArrayList;

public class Customer {
    Savings savings;
    Current current;
    Float requests;
    enum Branch {
        OSLO, BERGEN, HARDANGER
    }
    Customer.Branch branch;


    public Customer() {
        this.branch = Branch.BERGEN;
    }

    public Boolean setBranch(String branch) {

        return false;
    }
    public Float overdraft(Float amount){
        return -1.00f;
    }

    public boolean createRequests(Float amount){
        return false;
    }

    public boolean approveRequests(Float requests, boolean approved){
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


