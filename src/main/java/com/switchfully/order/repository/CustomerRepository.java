package com.switchfully.order.repository;

import com.switchfully.order.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
        populateCustomers();
    }

    private void populateCustomers() {
        customers.add(new Customer("Ruben", "Neven", "rubenneven@gmail.com", "0484 48 29 78"));
        customers.add(new Customer("Sofie", "Veryyssen", "sofieveryyssen@gmail.com", "0484 48 29 78"));
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }
}
