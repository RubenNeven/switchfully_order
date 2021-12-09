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

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    public static final int ITEM_NOT_IN_STOCK_SHIPPING_DAYS = 7;
    public static final int ITEM_IN_STOCK_SHIPPING_DAYS = 1;

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
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
        String itemId = orderDto.getItemGroupDto().getItemId();
        ItemDto itemById = itemService.getItemBy(itemId);

        if (itemService.getItemBy(itemId).getAmount() < orderDto.getItemGroupDto().getAmount()) {
            orderDto.getItemGroupDto().setShippingDate(LocalDate.now().plusDays(ITEM_NOT_IN_STOCK_SHIPPING_DAYS));
        } else {
            orderDto.getItemGroupDto().setShippingDate(LocalDate.now().plusDays(ITEM_IN_STOCK_SHIPPING_DAYS));
        }
        double totalPrice = calculateTotalPrice(orderDto);
        orderDto.setTotalPrice(totalPrice);
        itemService.decreaseStock(itemId, orderDto.getItemGroupDto().getAmount());
        Order order = orderMapper.mapToDomain(orderDto);
        itemService.getItemBy(itemId);
        orderRepository.add(order);
        return order;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersShippedToday() {
        return orderRepository.getAllOrders().stream()
                .filter(order -> order.getItemGroup().getShippingDate().isEqual(LocalDate.now()))
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersShippedByDay(String requestDate) {
        return orderRepository.getAllOrders().stream()
                .filter(order -> order.getItemGroup().getShippingDate().isEqual(LocalDate.parse(requestDate)))
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }


    private double calculateTotalPrice(OrderDto orderDto) {
        int orderAmount = orderDto.getItemGroupDto().getAmount();
        double itemPrice = itemService.getItemBy(orderDto.getItemGroupDto().getItemId()).getPrice();
        return orderAmount * itemPrice;
    }
}
