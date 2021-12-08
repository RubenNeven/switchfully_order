package com.switchfully.order.api.item;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.service.item.ItemService;
import com.switchfully.order.service.item.ItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getAllItems(){
        logger.info("Get all items called!");
        return itemService.getAllItems();
    }

    @GetMapping(path = "/{itemId}",produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto getItemBy(@PathVariable("itemId") String itemId){
        logger.info("Get item by id called!");
        return itemService.getItemBy(itemId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Item addItem(@RequestBody ItemDto itemDto){
        logger.info("Add item called!");
        return itemService.add(itemDto);
    }

    @PutMapping(path = "/{itemId}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Item update(@PathVariable("itemId") String itemId, @RequestBody ItemDto updateItemDto){
        logger.info("Update item called!");
        return itemService.update(itemId, updateItemDto);
    }
}
