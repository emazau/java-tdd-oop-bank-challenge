package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class coreTest {

    @Test
    public void createAccountTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current(0.00f, transactions );
        Savings savings = new Savings(0.00f, transactions );

        Assertions.assertEquals(new Current(0.00f, transactions ), customer.createAccount("current"));

        Assertions.assertEquals(new Savings(0.00f, transactions ), customer.createAccount("savings"));

        Assertions.assertEquals(null, customer.createAccount("savngs"));
        Assertions.assertEquals(null, customer.createAccount("curngs"));

    }
    @Test
    public void depositTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current(0.00f, transactions );
        Savings savings = new Savings(0.00f, transactions );


        Assertions.assertEquals(2500.00f, customer.depositFunds(2500.00f, savings));
        Assertions.assertEquals(5000.00f, customer.depositFunds(2500.00f, savings));

        Assertions.assertEquals(2500.00f, customer.depositFunds(2500.00f, current));
        Assertions.assertEquals(5000.00f, customer.depositFunds(2500.00f, current));

        Assertions.assertEquals(7150.00f, customer.depositFunds(2150.00f, current));

        //not valid
        Assertions.assertEquals(null, customer.depositFunds(2150.00f, null));


    }
    @Test
    public void withdrawTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current(0.00f, transactions );
        Savings savings = new Savings(0.00f, transactions );
        customer.depositFunds(10000.00f, savings);
        customer.depositFunds(15000.00f, current);



        Assertions.assertEquals(2500.00f, customer.withdrawFunds(7500.00f, savings) );
        Assertions.assertEquals(500.00f, customer.withdrawFunds(500.00f, savings) );


        Assertions.assertEquals(10000.00f, customer.withdrawFunds(5000.00f, current) );

        Assertions.assertEquals(500.00f, customer.withdrawFunds(9500.00f, current) );

        //dont work
        Assertions.assertEquals(-1.00f, customer.withdrawFunds(7500.00f, savings) );
        Assertions.assertEquals(-1.00f, customer.withdrawFunds(1000.00f, current) );
        Assertions.assertEquals(-1.00f, customer.withdrawFunds(501.00f, current) );

    }

    @Test
    public void bankStatementTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current(0.00f, transactions );
        Savings savings = new Savings(0.00f, transactions );


        Assertions.assertEquals(" ", customer.generateBankStatement(current) );


        //add more deposits, how do I test it? should I just do booleans?
        customer.depositFunds(10000.00f, savings);
        //Assertions.assertEquals(" ", customer.generateBankStatement(current) );

        customer.depositFunds(10000.00f, savings);
        customer.depositFunds(15000.00f, current);

    }




}
