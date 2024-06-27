package com.example.banksystemproject;

public abstract class Person implements Imethods {
    String firstName;
    String lastName;
    String email;
    String phoneNo;
    String setPass;
    String address;

    String sex;

    String birthdate;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String phoneNo,String setPass)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;

        this.setPass=setPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getSetPass() {
        return setPass;
    }

    public void setSetPass(String setPass) {
        this.setPass = setPass;
    }

    public abstract void printInfo(CustomerController c);
}
