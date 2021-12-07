package com.switchfully.order.domain.customer;


import com.switchfully.order.exception.InvalidCustomerException;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final Address address;
    private final String phoneNumber;

    public Customer(String firstName, String lastName, String emailAddress, Address address, String phoneNumber) throws RuntimeException {
        if (!isValidInput(firstName)) {
            throw new InvalidCustomerException("Please fill in firstname");
        } else if (!isValidInput(lastName)) {
            throw new InvalidCustomerException("Please fill in lastname");
        } else if (!isValidInput(emailAddress)) {
            throw new InvalidCustomerException("Please fill in email-address");
        } else if (!isValidInput(phoneNumber)) {
            throw new InvalidCustomerException("Please fill in phone number");
        } else if (!isValidInput(address.getStreet())) {
            throw new InvalidCustomerException("Please fill in street");
        } else if (!isValidInput(address.getHouseNumber())) {
            throw new InvalidCustomerException("Please fill in house number");
        } else if (!isValidInput(address.getCity())) {
            throw new InvalidCustomerException("Please fill in city");
        } else if (!isValidInput(address.getPostalCode())) {
            throw new InvalidCustomerException("Please fill in postal code");
        }
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public static boolean isValidInput(String inputString) {
        return inputString != null;
    }
}
