package com.switchfully.order.domain.item;

import com.switchfully.order.exception.InvalidItemException;

import java.util.UUID;

public class Item {
    private final String id;
    private String name;
    private String description;
    private double price;
    private int amount;

    public Item(String name, String description, double price, int amount) {
        if (!isValidInputString(name)) {
            throw new InvalidItemException("Please fill in item name");
        } else if (!isValidInputString(description)) {
            throw new InvalidItemException("Please fill in item description");
        } else if (!isValidInputNumber(price)) {
            throw new InvalidItemException("Please fill in item price");
        } else if (!isValidInputNumber(amount)) {
            throw new InvalidItemException("Please fill in item amount");
        }
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item(String id, String name, String description, double price, int amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public static boolean isValidInputString(String inputString) {
        return inputString != null;
    }


    public static boolean isValidInputNumber(Number inputNumber) {
        return inputNumber != null;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public Item setPrice(double price) {
        this.price = price;
        return this;
    }

    public Item setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
