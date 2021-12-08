package com.switchfully.order.domain.order;

import java.util.UUID;

public class Order {
    private final String orderId;
    private final String customerId;
    private ItemGroup itemGroup;
    private double totalPrice;

    public Order(String customerId, ItemGroup itemGroup, double totalPrice) {
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroup = itemGroup;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
