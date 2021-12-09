package com.switchfully.order.api.customer;

import com.switchfully.order.api.mapper.CustomerMapper;
import com.switchfully.order.domain.customer.AddressDto;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;
    @Autowired
    private CustomerMapper customerMapper;

/*    @Test
    void name(){
        Customer customer = customerController.createCustomer(
                new CustomerDto()
                        .setFirstName("Ruben")
                        .setLastName("Neven")
                        .setEmailAddress("rubenneven@gmail.com")
                        .setPhoneNumber("0484 48 29 78")
                        .setAddressDto(new AddressDto()
                                .setStreet("Pelserweg")
                                .setHouseNumber("5")
                                .setPostalCode("3590")
                                .setCity("Diepenbeek")));
        List<CustomerDto> allCustomers = customerController.getAllCustomers();
        System.out.println(allCustomers);
        Assertions.assertThat(allCustomers).contains(customerMapper.mapToDto(customer));
    }*/
}