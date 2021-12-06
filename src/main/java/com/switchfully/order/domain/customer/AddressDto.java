package com.switchfully.order.domain.customer;

public class AddressDto {
    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressDto setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    private String street;
    private String houseNumber;
    private String city;
    private String postalCode;


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
