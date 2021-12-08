package com.switchfully.order.api;

import com.switchfully.order.exception.InvalidCustomerException;
import com.switchfully.order.exception.InvalidItemException;
import com.switchfully.order.exception.ItemNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidCustomerException.class)
    protected void invalidUser(InvalidCustomerException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(InvalidItemException.class)
    protected void invalidItem(InvalidItemException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    protected void itemNotFound(ItemNotFoundException ex, HttpServletResponse response) throws IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
    }
}
