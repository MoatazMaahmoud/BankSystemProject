package com.example.banksystemproject;

public class Checkingaccount extends Account{
    public Checkingaccount(CustomerController u, double balance, String password)
    {
        super(u,balance,password);
        setMinBalance(1000);
        setWithdrawalLimit(1000, 50000);
        setInitialbalanceBalance(balance);
        setAccountType("CheckingAccount");
    }

    public Checkingaccount() {

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

}
