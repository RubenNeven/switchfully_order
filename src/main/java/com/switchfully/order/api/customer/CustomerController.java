package com.switchfully.order.api.customer;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.service.customer.CustomerService;
import com.switchfully.order.service.customer.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {
        logger.info("Get all customers!");
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{customerId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getAllCustomers(@PathVariable("customerId") String customerId) {
        logger.info("Get customer!");
        return customerService.getCustomerBy(customerId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Customer createCustomer(@RequestBody CustomerDto customerDto) {
        logger.info("Create customer called!");
        return customerService.createCustomer(customerDto);
    }
}
