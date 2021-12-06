package com.switchfully.order.domain;


public class Customer {
    public String firstName;
    public String lastName;
    public String emailAddress;
    public String phoneNumber;


    public Customer(String firstName, String lastName, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

}
