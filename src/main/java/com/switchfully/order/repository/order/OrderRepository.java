package com.switchfully.order.repository.order;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orders;

    public OrderRepository() {
        orders = new ArrayList<>();
        populate();
    }

    public void populate(){
        orders.add(new Order("customerId1", new ItemGroup("itemId1", 1, LocalDate.now()), 100));
        orders.add(new Order("customerId2", new ItemGroup("itemId2", 2, LocalDate.now().plusDays(1)), 200));
        orders.add(new Order("customerId3", new ItemGroup("itemId3", 3, LocalDate.now().plusDays(2)), 300));
    }

    public void add(Order order){
        orders.add(order);
    }

    public List<Order> getAllOrders(){
        return orders;
    }
}
