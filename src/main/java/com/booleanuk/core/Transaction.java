package com.booleanuk.core;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private Float amount;
    private Float balance;

    public Transaction(LocalDate date, Float amount, Float balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

}
