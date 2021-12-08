package com.switchfully.order.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(String message) {
        super(message);
    }
}
