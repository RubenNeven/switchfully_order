package com.switchfully.order.service.service;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;

import java.util.List;

public interface ItemService {

    public List<ItemDto> getAllItems();
}
