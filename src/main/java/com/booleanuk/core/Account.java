package com.booleanuk.core;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Account {
    protected Float balance;
    protected ArrayList<Transaction> transactions;


    public Account(ArrayList<Transaction> transactions) {
        this.balance = 0.00f;
        this.transactions = transactions;
    }

    public Float addAmount(Float amount){
        balance+= amount;
        transactions.add(new Transaction(LocalDate.now(),amount, balance, "+"));

        return balance;
    }

    public Float getBalance() {
        return balance;
    }

    public Float withdrawAmount(Float amount){
        balance-= amount;
        transactions.add(new Transaction(LocalDate.now(),amount, balance, "-"));

        return balance;
    }
    public boolean generateBankStatement(){
        String statement = " ";
        for (Transaction transaction : transactions) {
            statement += transaction.getInfo() + "\n";
        }
        System.out.println(statement);
        return true;
    }


    public Float getBalanceHardWay(){
        Float bal = 0.00f;
        for (Transaction transaction : transactions) {
            if (transaction.getType()){
                bal += transaction.getAmount();
            }
            else {
                bal -= transaction.getAmount();

            }
        }
        return bal;
    }



    }
