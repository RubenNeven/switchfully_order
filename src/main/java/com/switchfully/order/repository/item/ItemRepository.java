package com.switchfully.order.repository.item;

import com.switchfully.order.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    private final List<Item> items;

    @Autowired
    public ItemRepository(List<Item> items) {
        this.items = items;
    }

    public ItemRepository() {
        items = new ArrayList<>();
        populateItems();
    }

    private void populateItems() {
        items.add(new Item("Cervelo S5", "Road Bike", 10));
        items.add(new Item("Giro Aether", "Cycling Helmet", 10));
    }

    public List<Item> getAllItems() {
        return items;
    }
}
