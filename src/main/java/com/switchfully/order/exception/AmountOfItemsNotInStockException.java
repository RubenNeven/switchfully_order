package com.switchfully.order.exception;

public class AmountOfItemsNotInStockException extends RuntimeException {

    public AmountOfItemsNotInStockException(String message) {
        super(message);
    }
}
