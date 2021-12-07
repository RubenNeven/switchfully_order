package com.switchfully.order.domain.order;

import com.switchfully.order.service.item.ItemService;

import java.time.LocalDate;

public class ItemGroup {
    private final String itemId;
    private int amount;
    private LocalDate shippingDate;
    private ItemService itemService;

    public void setShippingDate(LocalDate shippingDate) {

    }

    public ItemGroup(String itemId, int amount, LocalDate shippingDate) {
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
