package com.switchfully.order.exception;

public class InvalidCustomerException extends RuntimeException {

    public InvalidCustomerException(String message) {
        super(message);
    }
}
