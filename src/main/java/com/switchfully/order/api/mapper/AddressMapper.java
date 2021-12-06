package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.customer.Address;
import com.switchfully.order.domain.customer.AddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto mapToDto(Address address){
        return new AddressDto()
                .setStreet(address.getStreet())
                .setCity(address.getCity())
                .setHouseNumber(address.getHouseNumber())
                .setPostalCode(address.getPostalCode());
    }

    public Address mapToDomain(AddressDto addressDto){
        return new Address(addressDto.getStreet(), addressDto.getHouseNumber(), addressDto.getCity(), addressDto.getPostalCode());
    }
}
