package com.switchfully.order.api.item;

import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.service.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(produces = "application/json")
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }
}
