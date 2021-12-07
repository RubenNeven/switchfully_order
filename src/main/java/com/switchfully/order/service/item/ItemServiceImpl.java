package com.switchfully.order.service.item;

import com.switchfully.order.api.mapper.ItemMapper;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
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
    public ItemDto getItemBy(String itemId) {
        Optional<Item> itemBy = itemRepository.getItemBy(itemId);
        if (itemBy.isEmpty()) {
            throw new NoSuchElementException("Item with id: " + itemId + " not found!");
        } else {
            return itemMapper.mapToDto(itemBy.get());
        }
    }
}
