package com.switchfully.order.domain.order;

public class OrderDto {
    private String orderId;
    private String customerId;
    private ItemGroupDto itemGroupDto;
    private double totalPrice;

    public String getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ItemGroupDto getItemGroupDto() {
        return itemGroupDto;
    }

    public OrderDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDto setItemGroupDto(ItemGroupDto itemGroupDto) {
        this.itemGroupDto = itemGroupDto;
        return this;
    }

    public OrderDto setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
