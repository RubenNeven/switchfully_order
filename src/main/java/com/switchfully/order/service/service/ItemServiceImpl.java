package com.switchfully.order.service.service;

import com.switchfully.order.api.mapper.ItemMapper;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.repository.item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemRepository.getAllItems().stream()
                .map(item -> itemMapper.mapToDto(item))
                .collect(Collectors.toList());
    }
}
