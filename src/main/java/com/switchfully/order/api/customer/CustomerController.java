package com.switchfully.order.api.customer;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.domain.user.OrderFeature;
import com.switchfully.order.service.authorisation.AuthorisationService;
import com.switchfully.order.service.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.switchfully.order.domain.user.OrderFeature.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final AuthorisationService authorisationService;

    @Autowired
    public CustomerController(CustomerService customerService, AuthorisationService authorisationService) {
        this.customerService = customerService;
        this.authorisationService = authorisationService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomers(@RequestHeader(required = false) String authorization ) {
        logger.info("Get all customers!");
        authorisationService.hasUserAccess(VIEW_ALL_CUSTOMERS, authorization );
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{customerId}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getAllCustomers(@PathVariable("customerId") String customerId, @RequestHeader(required = false) String emailAddress) {
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
