package com.switchfully.order.service.customer;

import com.switchfully.order.api.mapper.CustomerMapper;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.exception.InvalidCustomerException;
import com.switchfully.order.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDto> getAllCustomers(){
        return customerRepository.getAllCustomers().stream()
                .map(customerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerBy(String customerId) {
        Optional<Customer> customer = customerRepository.getCustomerBy(customerId);
        if (customer.isEmpty()){
            throw new InvalidCustomerException("Customer with id: " + customerId + " not found");
        } else {
            return customerMapper.mapToDto(customer.get());
        }
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto){
        Customer customer = customerMapper.mapToDomain(customerDto);
        customerRepository.createCustomer(customer);
        return customer;
    }
}
