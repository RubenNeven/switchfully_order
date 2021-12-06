package com.switchfully.order.domain.customer;


import com.switchfully.order.exception.InvalidUserException;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String emailAddress, Address address, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        if (!isValidInput(firstName)) {
            throw new InvalidUserException("Please fill in firstname");
        } else if (!isValidInput(lastName)) {
            throw new InvalidUserException("Please fill in lastname");
        } else if (!isValidInput(emailAddress)) {
            throw new InvalidUserException("Please fill in email-address");
        } else if (!isValidInput(phoneNumber)) {
            throw new InvalidUserException("Please fill in phonenumber");
        } else if (!isValidInput(address.getStreet())) {
            throw new InvalidUserException("Please fill in street");
        } else if (!isValidInput(address.getHouseNumber())) {
            throw new InvalidUserException("Please fill in house number");
        } else if (!isValidInput(address.getCity())) {
            throw new InvalidUserException("Please fill in city");
        } else if (!isValidInput(address.getPostalCode())) {
            throw new InvalidUserException("Please fill in postal code");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidInput(String inputString) {
        return inputString != null;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
