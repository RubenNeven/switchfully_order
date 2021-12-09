package com.switchfully.order.service.order;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;

import java.util.List;

public interface OrderService {

    Order add(OrderDto orderDto);

    List<OrderDto> getAllOrders();

    List<OrderDto> getOrdersShippedToday();

    List<OrderDto> getOrdersShippedByDay(String requestDate);
}
