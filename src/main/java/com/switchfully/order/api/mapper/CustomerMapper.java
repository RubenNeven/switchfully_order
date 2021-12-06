package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final AddressMapper addressMapper;

    @Autowired
    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDto mapToDto(Customer customer){
        return new CustomerDto()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setAddressDto(addressMapper.mapToDto(customer.getAddress()))
                .setEmailAddress(customer.getEmailAddress())
                .setPhoneNumber(customer.getPhoneNumber());
    }

    public Customer mapToDomain(CustomerDto customerDto){
        return new Customer(
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmailAddress(),
                addressMapper.mapToDomain(customerDto.getAddressDto()),
                customerDto.getPhoneNumber());
    }
}
