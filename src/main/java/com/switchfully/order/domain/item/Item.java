package com.switchfully.order.domain.item;

import com.switchfully.order.exception.InvalidItemException;

import java.util.UUID;

public class Item {
    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final int amount;

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
}
