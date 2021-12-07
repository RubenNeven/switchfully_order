package com.switchfully.order.domain.order;

public class OrderDto {
    private String orderId;
    private String customerId;
    private ItemGroupDto itemGroupDto;

    public String getOrderId() {
        return orderId;
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
}
