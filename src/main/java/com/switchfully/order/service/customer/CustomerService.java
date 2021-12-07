package com.switchfully.order.service.customer;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerBy(String customerId);

    Customer createCustomer(CustomerDto customerDto);
}
