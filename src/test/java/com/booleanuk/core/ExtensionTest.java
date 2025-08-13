package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ExtensionTest {
    @Test
    public void getBalHardWayTest(){
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
        Assertions.assertEquals(55000.00f, customer.getBalanceHardWay("savings") );

        customer.depositFunds(10000.00f, "current");
        customer.depositFunds(100000.00f, "current");
        customer.withdrawFunds(50000.00f, "current");
        customer.withdrawFunds(50000.00f, "current");
        customer.depositFunds(100000.00f, "current");
        customer.withdrawFunds(50000.00f, "current");
        customer.withdrawFunds(60000.00f, "current");



        Assertions.assertEquals(true, customer.generateBankStatement("current") );
        Assertions.assertEquals(0.00f, customer.getBalanceHardWay("current") );



    }

    @Test
    public void setBranchTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );
        customer.createAccount("current");
        customer.createAccount("saVings");

        Assertions.assertEquals(true, customer.setBranch("Oslo") );
        Assertions.assertEquals(false, customer.setBranch("Trondheim") );
        Assertions.assertEquals(true, customer.setBranch("Hardanger") );
        Assertions.assertEquals(true, customer.setBranch("BeRGen") );
        Assertions.assertEquals(false, customer.setBranch("Berrgen") );


    }

    @Test
    public void overdraftTest(){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );
        customer.createAccount("current");
        customer.createAccount("saVings");


        customer.depositFunds(1000.00f, "current");
        Assertions.assertEquals(true, customer.overdraft(10100.00f) );

        Assertions.assertEquals(true, customer.overdraft(50.00f) );

        Assertions.assertEquals(false, customer.overdraft(100.00f) );
        customer.depositFunds(1000.00f, "savings");
        Assertions.assertEquals(false, customer.overdraft(900.00f) );
        System.out.println("overdraft----");
        customer.generateBankStatement("current");



    }

    public void approveRequests(Float amount){
        Customer customer = new Customer();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Current current = new Current( transactions );
        Savings savings = new Savings(transactions );
        customer.createAccount("current");
        customer.createAccount("saVings");

        customer.depositFunds(1000.00f, "current");
        //try this
        Assertions.assertEquals(true, customer.createRequests(1300.00f) );
        Assertions.assertEquals(true, customer.approveRequests(1300.00f,false) );
        Assertions.assertEquals(true, customer.createRequests(1300.00f) );
        Assertions.assertEquals(true, customer.approveRequests(1300.00f,true) );

        customer.depositFunds(1300.00f, "current");

        Assertions.assertEquals(true, customer.createRequests(1300.00f) );

        Assertions.assertEquals(false, customer.approveRequests(1340.00f,true) );
        Assertions.assertEquals(false, customer.approveRequests(1300.00f,false) );
        Assertions.assertEquals(true, customer.approveRequests(1300.00f,true) );
        System.out.println("overdraft----");
        customer.generateBankStatement("current");
    }


}
