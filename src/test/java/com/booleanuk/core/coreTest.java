package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class coreTest {

    @Test
    public void createAccountTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );

        Assertions.assertEquals(true, customer.createAccount("current"));

        Assertions.assertEquals(true, customer.createAccount("saVings"));

        Assertions.assertEquals(false, customer.createAccount("savngs"));
        Assertions.assertEquals(false, customer.createAccount("curngs"));

    }
    @Test
    public void depositTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );
        customer.createAccount("current");
        customer.createAccount("saVings");

        Assertions.assertEquals(2500.00f, customer.depositFunds(2500.00f, "savings"));
        Assertions.assertEquals(5000.00f, customer.depositFunds(2500.00f, "savings"));

        Assertions.assertEquals(2500.00f, customer.depositFunds(2500.00f, "current"));
        Assertions.assertEquals(5000.00f, customer.depositFunds(2500.00f, "current"));

        Assertions.assertEquals(7150.00f, customer.depositFunds(2150.00f, "savings"));

        //not valid
        Assertions.assertEquals(-1.00f, customer.depositFunds(2150.00f, "sds"));


    }
    @Test
    public void withdrawTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );
        customer.createAccount("current");
        customer.createAccount("saVings");
        customer.depositFunds(10000.00f, "savings");
        customer.depositFunds(15000.00f, "current");



        Assertions.assertEquals(2500.00f, customer.withdrawFunds(7500.00f, "savings") );
        Assertions.assertEquals(2000.00f, customer.withdrawFunds(500.00f, "savings") );


        Assertions.assertEquals(10000.00f, customer.withdrawFunds(5000.00f, "current") );

        Assertions.assertEquals(500.00f, customer.withdrawFunds(9500.00f, "current") );

        //dont work
        Assertions.assertEquals(-1.00f, customer.withdrawFunds(7500.00f, "savings") );
        Assertions.assertEquals(-1.00f, customer.withdrawFunds(2500.00f, "savings") );
        Assertions.assertEquals(-1.00f, customer.withdrawFunds(501.00f, "current") );


        Assertions.assertEquals(00.00f, customer.withdrawFunds(500.00f, "current") );


    }

    @Test
    public void bankStatementTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );
        customer.createAccount("current");
        customer.createAccount("saVings");

        Assertions.assertEquals(false, customer.generateBankStatement("current") );


        //add more deposits, how do I test it? should I just do booleans?
        customer.depositFunds(10000.00f, "savings");
        //Assertions.assertEquals(" ", customer.generateBankStatement(current) );

        customer.depositFunds(10000.00f, "savings");
        customer.depositFunds(15000.00f, "savings");
        Assertions.assertEquals(true, customer.generateBankStatement("savings") );
        customer.depositFunds(15000.00f, "savings");
        customer.depositFunds(15000.00f, "savings");
        customer.depositFunds(15000.00f, "savings");
        customer.depositFunds(125000.00f, "savings");
        customer.withdrawFunds(150000.00f, "savings");

        Assertions.assertEquals(true, customer.generateBankStatement("savings") );

        customer.depositFunds(10000.00f, "current");
        customer.depositFunds(100000.00f, "current");
        customer.withdrawFunds(50000.00f, "current");
        customer.withdrawFunds(50000.00f, "current");
        customer.depositFunds(100000.00f, "current");
        customer.withdrawFunds(50000.00f, "current");
        customer.withdrawFunds(60000.00f, "current");



        Assertions.assertEquals(true, customer.generateBankStatement("current") );


    }




}
