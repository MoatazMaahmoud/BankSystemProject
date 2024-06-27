package com.example.banksystemproject;

public class Savingsaccount extends Account{

    Savingsaccount(CustomerController u,double balance,String password)
    {
        super(u,balance,password);
        setMinBalance(500);
        setWithdrawalLimit(500,20000);
        setInitialbalanceBalance(balance);
        setAccountType("SavingsAccount");
    }

    public Savingsaccount() {

    }

    @Override
    void setAccountType(String accountType) {
        this.accountType=accountType;
    }

    @Override
    void setMinBalance(double a) {
        minBalance=a;
    }

    @Override
    void setWithdrawalLimit(double l, double h) {
        minWithdrawal=l;
        maxWithdrawal=h;
    }

    @Override
    public String toString() {
        return accountType;
    }
    //The minimum balance required to maintain a savings account is usually low,
    // but for a Current Account it is much higher in comparison..

}
