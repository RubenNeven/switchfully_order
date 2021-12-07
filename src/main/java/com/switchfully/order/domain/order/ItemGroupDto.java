package com.switchfully.order.domain.order;

import java.time.LocalDate;

public class ItemGroupDto {
    private String itemId;
    private int amount;
    private LocalDate shippingDate;

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public ItemGroupDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public ItemGroupDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemGroupDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }
}
