package com.example.banksystemproject;

public class NormaCustomer extends CustomerController{
    public static int noofnormalCust=0;

    public  static int getNoofnormalCust(){
        return noofnormalCust;
    }

    public NormaCustomer() {
        super();
    }

   /* public NormaCustomer(String firstName, String lastName, String email, String phoneNo, String address, String sex, String birthdate) {
        super(firstName, lastName, email, phoneNo, address, sex,birthdate);
        noofnormalCust++;
    }*/


    public double minwithdrawal(){
        return 400;
    }
    public double maxwithdrawal(){
        return 10000;
    }
    public  boolean abilityToinvest(){
        return false;
    }
}
