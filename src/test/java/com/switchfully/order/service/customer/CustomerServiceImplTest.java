package com.switchfully.order.service.customer;

import com.switchfully.order.api.mapper.CustomerMapper;
import com.switchfully.order.domain.customer.AddressDto;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.exception.InvalidCustomerException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;


@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    CustomerMapper customerMapper;

    @Test
    void givenAnNonExistingCustomerId_whenGettingCustomerById_thenTheCorrectCustomerIsReturned() {
        Assertions.assertThatExceptionOfType(InvalidCustomerException.class).isThrownBy(() -> customerService.getCustomerBy("not an existing customer"));
    }

    @Test
    void givenACustomerDto_whenCreatingNewCustomerWithThisCustomerDto_thenTheCustomerIsAddedToTheCustomerRepository() {
        // Given
        CustomerDto customerDto = new CustomerDto()
                .setFirstName("FirstNameTest")
                .setLastName("LastNameTest")
                .setEmailAddress("email@email.com")
                .setPhoneNumber("PhoneNumber")
                .setAddressDto(new AddressDto()
                        .setCity("City")
                        .setHouseNumber("HouseNumber")
                        .setStreet("Street")
                        .setPostalCode("PostalCode"));
        // When
        Customer customer = customerService.createCustomer(customerDto);
        // Then
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getFirstName)).contains("FirstNameTest");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getLastName)).contains("LastNameTest");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getEmailAddress)).contains("email@email.com");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getPhoneNumber)).contains("PhoneNumber");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getAddressDto)
                .map(AddressDto::getCity)).contains("City");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getAddressDto)
                .map(AddressDto::getHouseNumber)).contains("HouseNumber");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getAddressDto)
                .map(AddressDto::getStreet)).contains("Street");
        Assertions.assertThat(customerService.getAllCustomers().stream()
                .map(CustomerDto::getAddressDto)
                .map(AddressDto::getPostalCode)).contains("PostalCode");
    }

}