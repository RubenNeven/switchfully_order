package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.Item;

import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final String customerId;
    private List<ItemGroup> itemGroups;

    public Order(String customerId, List<ItemGroup> itemGroups) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroups = itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
