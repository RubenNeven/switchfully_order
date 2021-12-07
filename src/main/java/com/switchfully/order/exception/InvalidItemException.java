package com.switchfully.order.exception;

public class InvalidItemException extends RuntimeException{

    public InvalidItemException(String message) {
        super(message);
    }
}
