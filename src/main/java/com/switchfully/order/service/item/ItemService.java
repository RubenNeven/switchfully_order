package com.switchfully.order.service.item;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> getAllItems();

    Item add(ItemDto itemDto);

    ItemDto getItemBy(String itemId);
}
