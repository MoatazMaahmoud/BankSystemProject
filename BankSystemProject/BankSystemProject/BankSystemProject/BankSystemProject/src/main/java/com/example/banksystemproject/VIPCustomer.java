package com.example.banksystemproject;

public class VIPCustomer extends CustomerController {
    public static int noofVipcust=0;

    public VIPCustomer() {
        super();
    }

    /*public VIPCustomer(String firstName, String lastName, String email, String phoneNo, String address, String sex, String birthdate) {
        super(firstName, lastName, email, phoneNo, address, sex, birthdate);
        noofVipcust++;
    }*/

    public double minwithdrawal(){
        return 1000;
    }
    public double maxwithdrawal(){
        return 100000;
    }
    public boolean abilityToinvest(){
        return true;
    }
    public static int getNoofVipcust(){
        return noofVipcust;
    }
}
