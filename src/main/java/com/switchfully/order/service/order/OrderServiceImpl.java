package com.switchfully.order.service.order;

import com.switchfully.order.api.mapper.OrderMapper;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;
import com.switchfully.order.exception.InvalidCustomerException;
import com.switchfully.order.repository.customer.CustomerRepository;
import com.switchfully.order.repository.item.ItemRepository;
import com.switchfully.order.repository.order.OrderRepository;
import com.switchfully.order.service.customer.CustomerService;
import com.switchfully.order.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
/*    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;*/
    private final ItemService itemService;
    private final CustomerService customerService;
    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository, ItemService itemService, CustomerService customerService) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
        this.customerService = customerService;
    }

    @Override
    public Order add(OrderDto orderDto) {
        CustomerDto customerById = customerService.getCustomerBy(orderDto.getCustomerId());
        ItemDto itemById = itemService.getItemBy(orderDto.getItemGroupDto().getItemId());
        Order order = orderMapper.mapToDomain(orderDto);
        orderRepository.add(order);
        return order;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
