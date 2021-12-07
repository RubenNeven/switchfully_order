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
        orders.add(new Order("customerId1", new ItemGroup("itemId1", 5, LocalDate.now())));
        orders.add(new Order("customerId2", new ItemGroup("itemId2", 5, LocalDate.now())));
    }

    public void add(Order order){
        orders.add(order);
    }

    public List<Order> getAllOrders(){
        return orders;
    }
}
