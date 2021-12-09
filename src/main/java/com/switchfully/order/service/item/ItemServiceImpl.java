package com.switchfully.order.service.item;

import com.switchfully.order.api.mapper.ItemMapper;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.exception.AmountOfItemsNotInStockException;
import com.switchfully.order.exception.ItemNotFoundException;
import com.switchfully.order.repository.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.getAllItems().stream()
                .map(itemMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Item add(ItemDto itemDto) {
        Item item = itemMapper.mapToDomain(itemDto);
        itemRepository.add(item);
        return item;
    }

    @Override
    public void decreaseStock(String itemId, int amount) {
        Optional<Item> itemById = itemRepository.getItemBy(itemId);
        if (itemById.isEmpty()) {
            throw new ItemNotFoundException("Item with id: " + itemId + " not found!");
        } else {
            int currentAmount = itemById.get().getAmount();
            itemById.get().setAmount(currentAmount - amount);
        }
    }


    @Override
    public ItemDto getItemBy(String itemId) {
        Optional<Item> itemBy = itemRepository.getItemBy(itemId);
        if (itemBy.isEmpty()) {
            throw new ItemNotFoundException("Item with id: " + itemId + " not found!");
        } else {
            return itemMapper.mapToDto(itemBy.get());
        }
    }

    @Override
    public Item update(String itemId, ItemDto updateItemDto) {
        Item updateItem = itemMapper.mapToDomain(itemId, updateItemDto);
        itemRepository.update(itemId, updateItem);
        return updateItem;
    }

    @Override
    public List<ItemDto> getItemsBasedOnStockLevel(String stockLevel) {
        List<ItemDto> itemsByStockLevel;
        switch (stockLevel){
            case "STOCK_LOW":
                itemsByStockLevel = itemRepository.getAllItems().stream()
                        .filter(item -> item.getAmount() < 5)
                        .map(itemMapper::mapToDto)
                        .collect(Collectors.toList());
                break;
            case "STOCK_MEDIUM":
                itemsByStockLevel =itemRepository.getAllItems().stream()
                        .filter(item -> item.getAmount() > 5)
                        .filter(item -> item.getAmount() < 10)
                        .map(itemMapper::mapToDto)
                        .collect(Collectors.toList());
                break;
            case "STOCK_HIGH":
                itemsByStockLevel = itemRepository.getAllItems().stream()
                        .filter(item -> item.getAmount() >= 10)
                        .map(itemMapper::mapToDto)
                        .collect(Collectors.toList());
                break;
            default: itemsByStockLevel = null;
        }
        return itemsByStockLevel;
    }
}
