package com.example.banksystemproject;

public abstract class Account {
    private double initialbalance;
    private double currentBalance=0.0;
    String accountType;
    private long accountNo;
    private String password;
    private CustomerController user;
    public static int noofaccounts=0;
    double minBalance;
    double minWithdrawal;
    double maxWithdrawal;
    public Account(){

    }
    public Account(CustomerController u, double initialbalance, String password){
        user=u;
        this.initialbalance=initialbalance;
        this.accountNo=generateAccno();
        this.password=password;

        noofaccounts++;

    }
    public static long generateAccno(){
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return number;


    }
    abstract void setMinBalance(double a);
    abstract void setWithdrawalLimit(double l, double h);
    abstract void setAccountType(String accountType);
    public static int getNoofaccounts(){
        return noofaccounts;
    }
    public void setInitialbalanceBalance(double balance) {
        this.initialbalance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(CustomerController user) {
        this.user = user;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getBalance() {
        if(currentBalance==0)
            currentBalance=initialbalance;
        return currentBalance;
    }
    /*public String toString()
    {
        return "\n"+ accountNo + "\n" + password + "\n" + balance + "\n" + user + "\n";
    }*/

    public String getAccountType() {
        return accountType;
    }
}
