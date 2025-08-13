package com.booleanuk.core;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final LocalDate date;
    private final  Float amount;
    private final Float balance;
    private final String type;

    public Transaction(LocalDate date, Float amount, Float balance, String type) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
        this.type = type;
    }

    public String getInfo(){
        return "Date: " + date.toString() + "\t Amount: " + type+amount.toString() + "\t balance after " + balance.toString();
    }

    public Float getAmount() {
        return amount;
    }

    public boolean getType() {
        if (Objects.equals(type, "-")){
            return false;
        }
        else if (Objects.equals(type, "+"))
            return true;

        return false;
    }
}
