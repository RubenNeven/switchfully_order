package com.switchfully.order.domain.customer;

import com.switchfully.order.exception.InvalidUserException;

public class CustomerDto {
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private AddressDto addressDto;
    private String phoneNumber;



    public CustomerDto setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
        return this;
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerDto setId(String id) {
        this.id = id;
        return this;
    }

    public CustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CustomerDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
