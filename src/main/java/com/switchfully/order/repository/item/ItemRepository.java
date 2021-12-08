package com.switchfully.order.repository.item;

import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemDto;
import com.switchfully.order.exception.ItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class ItemRepository {
    private final List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        populateItems();
    }

    private void populateItems() {
        items.add(new Item("Cervelo S5", "Road Bike", 5500.99, 10));
        items.add(new Item("Giro Aether", "Cycling Helmet", 159.99, 10));
    }

    public List<Item> getAllItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Optional<Item> getItemBy(String itemId) {
        return items.stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst();
    }

    /**
     * Update item methode 2
     * */
    public void update(String itemId, Item updateItem) {
        Optional<Item> existingItem = getItemBy(itemId);
        if (existingItem.isEmpty()) {
            throw new ItemNotFoundException("Item with id: " + itemId + " not found!");
        } else {
            int indexOfExistingItem = items.indexOf(existingItem.get());
            System.out.println(indexOfExistingItem);
            items.set(indexOfExistingItem, updateItem);
        }
    }
}
