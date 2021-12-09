package com.switchfully.order.api.item;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.domain.user.OrderFeature;
import com.switchfully.order.service.authorisation.AuthorisationService;
import com.switchfully.order.service.item.ItemService;
import com.switchfully.order.service.item.ItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.switchfully.order.domain.user.OrderFeature.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
    private final AuthorisationService authorisationService;

    @Autowired
    public ItemController(ItemServiceImpl itemService, AuthorisationService authorisationService) {
        this.itemService = itemService;
        this.authorisationService = authorisationService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(OK)
    public List<ItemDto> getAllItems() {
        logger.info("Get all items called!");
        return itemService.getAllItems();
    }

    @GetMapping(path = "/itemsByStockLevel",produces = "application/json")
    @ResponseStatus(OK)
    public List<ItemDto> getItemsBasedOnStockLevel(@RequestParam String stockLevel){
        return itemService.getItemsBasedOnStockLevel(stockLevel);

    }

    @GetMapping(path = "/{itemId}", produces = "application/json")
    @ResponseStatus(OK)
    public ItemDto getItemBy(@PathVariable("itemId") String itemId) {
        logger.info("Get item by id called!");
        return itemService.getItemBy(itemId);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(OK)
    public Item addItem(@RequestBody ItemDto itemDto, @RequestHeader(required = false, name = "authorization") String emailAddress) {
        logger.info("Add item called!");
        authorisationService.hasUserAccess(ADD_ITEM, emailAddress);
        return itemService.add(itemDto);
    }

    @PutMapping(path = "/{itemId}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(OK)
    public Item update(@PathVariable("itemId") String itemId, @RequestBody ItemDto updateItemDto, @RequestHeader(required = false, name = "authorization") String emailAddress) {
        logger.info("Update item called!");
        authorisationService.hasUserAccess(UPDATE_ITEM, emailAddress);
        return itemService.update(itemId, updateItemDto);
    }
}
