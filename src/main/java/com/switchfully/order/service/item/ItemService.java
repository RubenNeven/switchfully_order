package com.switchfully.order.service.item;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;

import java.util.List;

public interface ItemService {

    List<ItemDto> getAllItems();

    Item add(ItemDto itemDto);

    void decreaseStock(String itemId, int amount);

    ItemDto getItemBy(String itemId);

    Item update(String itemId, ItemDto updateItemDto);

    List<ItemDto> getItemsBasedOnStockLevel(String stockLevel);
}
