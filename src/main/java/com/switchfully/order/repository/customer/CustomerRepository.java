package com.switchfully.order.repository.customer;

import com.switchfully.order.domain.customer.Address;
import com.switchfully.order.domain.customer.Customer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CustomerRepository {
    private final List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
        populateCustomers();
    }

    private void populateCustomers() {
        customers.add(new Customer("Ruben", "Neven", "rubenneven@gmail.com", new Address("Pelserweg", "5 bus 14", "Diepenbeek", "3590"), "0484 48 29 78"));
        customers.add(new Customer("Sofie", "Veryyssen", "sofieveryyssen@gmail.com", new Address("Pelserweg", "5 bus 14", "Diepenbeek", "3590"), "0484 48 29 78"));
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public void createCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer getCustomerBy(String customerId) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst()
                .get();
    }
}
