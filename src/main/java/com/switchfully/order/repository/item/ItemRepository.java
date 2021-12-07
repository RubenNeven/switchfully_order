package com.switchfully.order.repository.item;

import com.switchfully.order.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public Item getItemBy(String itemId) {
        return items.stream()
                .filter(item -> item.getId().equals(itemId))
                .findFirst()
                .get();
    }
}
