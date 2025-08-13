package com.booleanuk.core;

import java.util.ArrayList;

public class Account {
    protected Float balance;
    protected ArrayList<Transaction> transactions;

    public Account(Float balance, ArrayList<Transaction> transactions) {
        this.balance = balance;
        this.transactions = transactions;
    }
}
