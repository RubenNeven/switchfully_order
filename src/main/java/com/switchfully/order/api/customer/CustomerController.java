package com.switchfully.order.api.customer;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.service.customer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers() {
        return customerServiceImpl.getAllCustomers();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Customer createCustomer(@RequestBody CustomerDto customerDto){
        return customerServiceImpl.createCustomer(customerDto);
    }
}
