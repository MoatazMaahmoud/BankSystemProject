package com.example.banksystemproject;

public class ATM  {
    private String atm_location;
    private  Account acc;
    public ATM(String atm_location, Account acc) {
        this.atm_location = atm_location;
        this.acc=acc;
    }

    public static void deposit(Account a, double x){
        a.setCurrentBalance(a.getBalance()+x);
    }
    public static void withdraw(Account a,double x){
        a.setCurrentBalance(a.getBalance()+x);
    }
    public static double checkbalance(Account a){
        return a.getBalance();
    }

}
