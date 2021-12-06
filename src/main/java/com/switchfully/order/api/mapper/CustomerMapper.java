package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.exception.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDto mapToDto(Customer customer) {
        return new CustomerDto()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setAddressDto(addressMapper.mapToDto(customer.getAddress()))
                .setEmailAddress(customer.getEmailAddress())
                .setPhoneNumber(customer.getPhoneNumber());
    }

    public Customer mapToDomain(CustomerDto customerDto) {
        if (customerDto.getFirstName() == null) {
            throw new InvalidUserException("Please fill in firstname");
        } else if (customerDto.getLastName() == null) {
            throw new InvalidUserException("Please fill in lastname");
        } else if (customerDto.getEmailAddress() == null) {
            throw new InvalidUserException("Please fill in email-address");
        } else if (customerDto.getPhoneNumber() == null) {
            throw new InvalidUserException("Please fill in phone number");
        } else if (customerDto.getAddressDto().getStreet() == null) {
            throw new InvalidUserException("Please fill in street");
        } else if (customerDto.getAddressDto().getHouseNumber() == null) {
            throw new InvalidUserException("Please fill in housenumber");
        } else if (customerDto.getAddressDto().getCity() == null) {
            throw new InvalidUserException("Please fill in city");
        } else if (customerDto.getAddressDto().getPostalCode() == null) {
            throw new InvalidUserException("Please fill in postal code");
        } else {
            return new Customer(
                    customerDto.getFirstName(),
                    customerDto.getLastName(),
                    customerDto.getEmailAddress(),
                    addressMapper.mapToDomain(customerDto.getAddressDto()),
                    customerDto.getPhoneNumber());
        }
    }
}
