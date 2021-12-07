package com.switchfully.order.api.order;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;
import com.switchfully.order.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAllOrders(){
        logger.info("Get all orders called");
        return orderService.getAllOrders();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Order createOrder(@RequestBody OrderDto orderDto){
        logger.info("Create order called");
        return orderService.add(orderDto);
    }
}
