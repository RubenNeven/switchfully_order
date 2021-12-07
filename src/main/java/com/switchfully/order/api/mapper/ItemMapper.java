package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto mapToDto(Item item){
        return new ItemDto()
                .setId(item.getId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setAmount(item.getAmount());
    }

    public Item mapToDomain(ItemDto itemDto){
        return new Item(itemDto.getName(), itemDto.getDescription(), itemDto.getAmount());
    }
}
