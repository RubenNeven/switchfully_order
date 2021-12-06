package com.switchfully.order.domain.customer;

public class Address {
    private final String street;
    private final String houseNumber;
    private final String city;
    private final String postalCode;

    public Address(String street, String houseNumber, String city, String postalCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
