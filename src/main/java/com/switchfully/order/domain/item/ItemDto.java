package com.switchfully.order.domain.item;

public class ItemDto {
    private String id;
    private String name;
    private String description;
    private double price;

    private int amount;

    public ItemDto setId(String id) {
        this.id = id;
        return this;
    }

    public ItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public ItemDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemDto setPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
