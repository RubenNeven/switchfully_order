package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.domain.order.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    private final ItemGroupMapper itemGroupMapper;

    @Autowired
    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public OrderDto mapToDto(Order order){
        return new OrderDto()
                .setOrderId(order.getOrderId())
                .setCustomerId(order.getCustomerId())
                .setItemGroupDto(itemGroupMapper.mapToDto(order.getItemGroup()))
                .setTotalPrice(order.getTotalPrice());
    }

    public Order mapToDomain(OrderDto orderDto){
        return new Order(orderDto.getCustomerId(), itemGroupMapper.mapToDomain(orderDto.getItemGroupDto()), orderDto.getTotalPrice());
    }


}
